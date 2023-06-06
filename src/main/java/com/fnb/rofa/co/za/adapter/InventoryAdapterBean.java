package com.fnb.rofa.co.za.adapter;

import com.fnb.rofa.co.za.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class InventoryAdapterBean implements InventoryAdapter{

    @Value("http://localhost:8082")
    String threeMonthsMilestoneUrl;

    private UriComponentsBuilder createUriComponent(String path) {
        return UriComponentsBuilder.fromHttpUrl(threeMonthsMilestoneUrl + path);
    }

    private HttpHeaders httpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Override
    public String getJiraHoursLogged(String item1) {

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders());

        UriComponentsBuilder builder = createUriComponent("/api/fnb/get-item/{item1}");
        String requestUrl = builder.build(false).toUriString();
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, String.class, item1).getBody();
        } catch (ResourceAccessException rae) {
            throw new HttpServerErrorException(HttpStatus.SERVICE_UNAVAILABLE, "Inventory Service Unavailable");
        }

    }

    @Override
    public Order findByUserId(Long userId) {
        HttpEntity<Order> requestEntity = new HttpEntity<>(httpHeaders());

        UriComponentsBuilder builder = createUriComponent("/api/fnb/order/invoice/{userId}");
        String requestUrl = builder.build(false).toUriString();
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.exchange(requestUrl, HttpMethod.GET, requestEntity, Order.class, userId).getBody();
        } catch (ResourceAccessException rae) {
            throw new HttpServerErrorException(HttpStatus.SERVICE_UNAVAILABLE, "Inventory Service Unavailable");
        }    }
}
