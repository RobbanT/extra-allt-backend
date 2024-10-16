package com.backend.extraallt.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.aggregation.VariableOperators.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.extraallt.models.Product;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem;
import java.util.*;

@CrossOrigin
@RestController
public class CheckoutController {
    @Value("${stripe.api.key}")
    String stripeApiKey;

    private LineItem addProduct(String title, String imagePath, Long price, Long quantity) {
        return SessionCreateParams.LineItem.builder().setPriceData(
            SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency("sek").setProductData(
                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                    .setName(title)
                    .addImage(imagePath)
                    .build()
                ).setUnitAmount(price).build()
            ).setQuantity(quantity).build();
    }
    
    @PostMapping("/create-checkout-session")
    public Map<String, String> createCheckoutSession(@RequestBody List<Product> cart) {
        Stripe.apiKey = "stripeApiKey";
        List<LineItem> lineItems = new ArrayList<>();
        
        for (Item item : cart) {
            String stripeProductId = item.getStripeProductId();
            // Kontrollera att produkt-ID:t är giltigt
            if (stripeProductId != null && !stripeProductId.isEmpty()) {
                try {
                    com.stripe.model.Product stripeProduct = com.stripe.model.Product
                            .retrieve(item.getStripeProductId());
                    String name = stripeProduct.getName();
                    String imagePath = stripeProduct.getImages().get(0); // Hämta den första bilden
                    Long price = item.getPrice(); // Antag att priset fortfarande kommer från din `Item`

                    // Skapa en ny LineItem för varje produkt
                    LineItem newLineItem = addProduct(name, imagePath, price, item.getCount());
                    lineItems.add(newLineItem);
                } catch (Exception e) {
                    System.out.println("Fel: " + e.getMessage());
                }
            } else {
                System.out.println("Ogiltig produkt-ID: " + stripeProductId);
            }
        }

        // Kontrollera att lineItems inte är tom
        if (lineItems.isEmpty()) {
            System.out.println("Inga produkter att lägga till i kassan.");
            return null; // Eller någon annan lämplig åtgärd
        }

        SessionCreateParams params = SessionCreateParams.builder()
                .setUiMode(SessionCreateParams.UiMode.EMBEDDED)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setReturnUrl("http://127.0.0.1:5500/src/main/resources/templates/confirmed.html")
                .addAllLineItem(lineItems)
                .build();

        Map<String, String> map = new HashMap<>();
        try {
            map.put("clientSecret",
                    Session.create(params).getRawJsonObject().getAsJsonPrimitive("client_secret").getAsString());
        } catch (Exception e) {
            System.out.println("Fel: " + e.getMessage());
        }

        return map;
    }
}
