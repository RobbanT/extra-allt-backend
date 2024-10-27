package com.backend.extraallt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.stripe.param.checkout.SessionCreateParams.*;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;
import com.backend.extraallt.models.CartItem;
import com.stripe.model.checkout.Session;
import com.stripe.Stripe;
import java.util.*;

@Service
public class CheckoutService {
    @Autowired
    private UserService userService;

    @Value("${stripe.api.key}")
    String stripeApiKey;

    private LineItem addProduct(String title, String imagePath, Long price, Long quantity) {
        return SessionCreateParams.LineItem.builder().setPriceData(
                SessionCreateParams.LineItem.PriceData.builder()
                        .setCurrency("sek").setProductData(
                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName(title)
                                        .addImage(imagePath)
                                        .build())
                        .setUnitAmount(price).build())
                .setQuantity(quantity).build();
    }

    public Map<String, String> createCheckoutSession(List<CartItem> cart) {
        Stripe.apiKey = stripeApiKey;
        List<LineItem> lineItems = new ArrayList<>();
        if (cart == null || cart.isEmpty()) {
            return new HashMap<>();
        }

        for (CartItem cartItem : cart) {
            lineItems.add(
                    addProduct(cartItem.getTitle(), cartItem.getImage(), cartItem.getPrice(),
                            cartItem.getQuantity()));
        }

        SessionCreateParams params = SessionCreateParams.builder()
                .setUiMode(SessionCreateParams.UiMode.EMBEDDED)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setRedirectOnCompletion(RedirectOnCompletion.NEVER)
                .addAllLineItem(lineItems).build();

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