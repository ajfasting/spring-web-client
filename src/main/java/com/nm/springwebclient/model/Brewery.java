package com.nm.springwebclient.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Brewery {
    

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("brewery_type")
    private String breweryType;

    @JsonProperty("street")
    private String street;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("longitude")
    private BigDecimal longitude;

    @JsonProperty("latitude")
    private BigDecimal latitude;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("website_url")
    private String websiteUrl;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("tag_list")
    private List<Object> tagList = null;

}