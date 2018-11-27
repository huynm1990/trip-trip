package com.org.triptrip.utils;

import android.util.Log;

import com.google.android.gms.common.util.Strings;
import com.org.triptrip.common.AddressDTO;
import com.org.triptrip.common.InteractionDTO;
import com.org.triptrip.common.ItemViewDTO;
import com.org.triptrip.common.OpeningHoursDTO;
import com.org.triptrip.common.ServiceDetailDTO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONUtils {

    /**
     * Parse JSON Array to list of ItemViewDTO Java object
     * @param jsonArray json array
     * @return list of ItemViewDTO Java object
     */
    public static List<ItemViewDTO> parseJSONToItemViewDTO(JSONArray jsonArray) {

        List<ItemViewDTO> itemViewDTOList = new ArrayList<ItemViewDTO>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ItemViewDTO.ItemViewDTOBuilder itemViewDTOBuilder = ItemViewDTO.builder();
                if (!jsonObject.isNull("uuid")) {
                    itemViewDTOBuilder.uuid(jsonObject.getString("uuid"));
                }
                if (!jsonObject.isNull("id")) {
                    itemViewDTOBuilder.id(Integer.valueOf(jsonObject.getString("id")));
                }
                if (!jsonObject.isNull("captchaResponse")) {
                    itemViewDTOBuilder.captchaResponse(jsonObject.getString("captchaResponse"));
                }

                itemViewDTOBuilder.created(new Date(jsonObject.getLong("created")));
                itemViewDTOBuilder.updated(new Date(jsonObject.getLong("updated")));
                if (!jsonObject.isNull("itemType")) {
                    itemViewDTOBuilder.itemType(jsonObject.getString("itemType"));
                }
                if (!jsonObject.isNull("itemKind")) {
                    itemViewDTOBuilder.itemKind(jsonObject.getString("itemKind"));
                }
                if (!jsonObject.isNull("level")) {
                    itemViewDTOBuilder.level(jsonObject.getString("level"));
                }
                if (!jsonObject.isNull("ownerId")) {
                    itemViewDTOBuilder.ownerId(jsonObject.getString("ownerId"));
                }
                if (!jsonObject.isNull("ownerName")) {
                    itemViewDTOBuilder.ownerName(jsonObject.getString("ownerName"));
                }
                if (!jsonObject.isNull("ownerImage")) {
                    itemViewDTOBuilder.ownerImage(jsonObject.getString("ownerImage"));
                }
                if (!jsonObject.isNull("title")) {
                    itemViewDTOBuilder.title(jsonObject.getString("title"));
                }
                if (!jsonObject.isNull("detail")) {
                    itemViewDTOBuilder.detail(jsonObject.getString("detail"));
                }
                if (!jsonObject.isNull("description")) {
                    itemViewDTOBuilder.description(jsonObject.getString("description"));
                }
                if (!jsonObject.isNull("destination")) {
                    itemViewDTOBuilder.destination(jsonObject.getString("destination"));
                }
                if (!jsonObject.isNull("status")) {
                    itemViewDTOBuilder.status(jsonObject.getString("status"));
                }
                if (!jsonObject.isNull("newPrice")) {
                    itemViewDTOBuilder.newPrice(new BigDecimal(jsonObject.getString("newPrice")));
                }
                if (!jsonObject.isNull("oldPrice")) {
                    itemViewDTOBuilder.oldPrice(new BigDecimal(jsonObject.getString("oldPrice")));
                }
                if (!jsonObject.isNull("fromPrice")) {
                    itemViewDTOBuilder.fromPrice(new BigDecimal(jsonObject.getString("fromPrice")));
                }
                if (!jsonObject.isNull("toPrice")) {
                    itemViewDTOBuilder.toPrice(new BigDecimal(jsonObject.getString("toPrice")));
                }
                if (!jsonObject.isNull("currency")) {
                    itemViewDTOBuilder.currency(jsonObject.getString("currency"));
                }
                if (!jsonObject.isNull("priceType")) {
                    itemViewDTOBuilder.priceType(jsonObject.getString("priceType"));
                }
                if (!jsonObject.isNull("comparablePrice")) {
                    itemViewDTOBuilder.comparablePrice(new BigDecimal(jsonObject.getString("comparablePrice")));
                }
                if (!jsonObject.isNull("imageId")) {
                    itemViewDTOBuilder.imageId(jsonObject.getString("imageId"));
                }
                if (!jsonObject.isNull("originalImage")) {
                    itemViewDTOBuilder.originalImage(jsonObject.getString("originalImage"));
                }
                if (!jsonObject.isNull("largeImage")) {
                    itemViewDTOBuilder.largeImage(jsonObject.getString("largeImage"));
                }
                if (!jsonObject.isNull("mediumImage")) {
                    itemViewDTOBuilder.mediumImage(jsonObject.getString("mediumImage"));
                }
                if (!jsonObject.isNull("smallImage")) {
                    itemViewDTOBuilder.smallImage(jsonObject.getString("smallImage"));
                }
                if (!jsonObject.isNull("imageDescription")) {
                    itemViewDTOBuilder.imageDescription(jsonObject.getString("imageDescription"));
                }
                if (!jsonObject.isNull("imageDimension")) {
                    itemViewDTOBuilder.imageDimension(jsonObject.getString("imageDimension"));
                }

                // categoryList
                if (!jsonObject.isNull("categoryList")) {
                    JSONArray categoryJSONArray = jsonObject.getJSONArray("categoryList");
                    List<String> categoryList = new ArrayList<String>();
                    for (int c = 0; c < categoryJSONArray.length(); c++) {
                        categoryList.add(categoryJSONArray.getString(c));
                    }
                    itemViewDTOBuilder.categoryList(categoryList);
                }

                // keywordList
                if (!jsonObject.isNull("keywordList")) {
                    JSONArray keywordJSONArray = jsonObject.getJSONArray("keywordList");
                    List<String> keywordList = new ArrayList<String>();
                    for (int k = 0; k < keywordJSONArray.length(); k++) {
                        keywordList.add(keywordJSONArray.getString(k));
                    }
                    itemViewDTOBuilder.keywordList(keywordList);
                }

                // interactionList
                if (!jsonObject.isNull("interactionList")) {
                    JSONArray interactionJSONArray = jsonObject.getJSONArray("interactionList");
                    List<InteractionDTO> interactionList = new ArrayList<InteractionDTO>();
                    for (int k = 0; k < interactionJSONArray.length(); k++) {
                        JSONObject interactionJsonObject = interactionJSONArray.getJSONObject(k);
                        InteractionDTO.InteractionDTOBuilder interactionDTOBuilder = InteractionDTO.builder();
                        interactionDTOBuilder.type(interactionJsonObject.getString("type"));
                        interactionDTOBuilder.order(Integer.valueOf(interactionJsonObject.getString("order")));
                        interactionDTOBuilder.key(interactionJsonObject.getString("key"));
                        interactionDTOBuilder.name(interactionJsonObject.getString("name"));
                        interactionDTOBuilder.count(Integer.valueOf(interactionJsonObject.getString("count")));

                        interactionList.add(interactionDTOBuilder.build());
                    }
                    itemViewDTOBuilder.interactionList(interactionList);
                }


                itemViewDTOBuilder.followers(Integer.valueOf(jsonObject.getString("followers")));
                itemViewDTOBuilder.comments(Long.valueOf(jsonObject.getString("comments")));
                itemViewDTOBuilder.accounts(Integer.valueOf(jsonObject.getString("accounts")));
                itemViewDTOBuilder.views(Integer.valueOf(jsonObject.getString("views")));

                // serviceDetail
                itemViewDTOBuilder.serviceDetail(parseJSONToServiceDetailDTO(jsonObject));
                // itemViewDTOList
                ItemViewDTO itemViewDTO = itemViewDTOBuilder.build();
                itemViewDTOList.add(itemViewDTO);
            } catch (Exception e) {
                Log.e("ERROR", "ItemViewDTO", e);
            }
        }


        return itemViewDTOList;
    }

    /**
     * Parse JSON object to ServiceDetailDTO Java object
     * @param jsonObject json object
     * @return ServiceDetailDTO Java object
     */
    public static ServiceDetailDTO parseJSONToServiceDetailDTO(JSONObject jsonObject) {
        ServiceDetailDTO.ServiceDetailDTOBuilder serviceDetailDTOBuilder = ServiceDetailDTO.builder();
        try {
            if (!jsonObject.isNull("serviceDetail")) {
                JSONObject serviceDetailJSONObject = jsonObject.getJSONObject("serviceDetail");
                if (!serviceDetailJSONObject.isNull("itemId")) {
                    serviceDetailDTOBuilder.itemId(serviceDetailJSONObject.getString("itemId"));
                }
                if (!serviceDetailJSONObject.isNull("manageType")) {
                    serviceDetailDTOBuilder.manageType(serviceDetailJSONObject.getString("manageType"));
                }
                if (!serviceDetailJSONObject.isNull("affiliateLink")) {
                    serviceDetailDTOBuilder.affiliateLink(serviceDetailJSONObject.getString("affiliateLink"));
                }
                if (!serviceDetailJSONObject.isNull("priceType")) {
                    serviceDetailDTOBuilder.priceType(serviceDetailJSONObject.getString("priceType"));
                }
                if (!serviceDetailJSONObject.isNull("currency")) {
                    serviceDetailDTOBuilder.currency(serviceDetailJSONObject.getString("currency"));
                }
                if (!serviceDetailJSONObject.isNull("oldPrice")) {
                    serviceDetailDTOBuilder.oldPrice(new BigDecimal(serviceDetailJSONObject.getString("oldPrice")));
                }
                if (!serviceDetailJSONObject.isNull("newPrice")) {
                    serviceDetailDTOBuilder.newPrice(new BigDecimal(serviceDetailJSONObject.getString("newPrice")));
                }
                if (!serviceDetailJSONObject.isNull("fromPrice")) {
                    serviceDetailDTOBuilder.fromPrice(new BigDecimal(serviceDetailJSONObject.getString("fromPrice")));
                }
                if (!serviceDetailJSONObject.isNull("toPrice")) {
                    serviceDetailDTOBuilder.toPrice(new BigDecimal(serviceDetailJSONObject.getString("toPrice")));
                }
                if (!serviceDetailJSONObject.isNull("phone")) {
                    serviceDetailDTOBuilder.phone(serviceDetailJSONObject.getString("phone"));
                }
                if (!serviceDetailJSONObject.isNull("email")) {
                    serviceDetailDTOBuilder.email(serviceDetailJSONObject.getString("email"));
                }
                if (!serviceDetailJSONObject.isNull("website")) {
                    serviceDetailDTOBuilder.website(serviceDetailJSONObject.getString("website"));
                }
                if (!serviceDetailJSONObject.isNull("holidayAvailability")) {
                    serviceDetailDTOBuilder.holidayAvailability(serviceDetailJSONObject.getString("holidayAvailability"));
                }
                if (!serviceDetailJSONObject.isNull("note")) {
                    serviceDetailDTOBuilder.note(serviceDetailJSONObject.getString("note"));
                }
                serviceDetailDTOBuilder.address(parseJSONToAddressDTO(jsonObject));
                serviceDetailDTOBuilder.openingHoursList(parseJSONToOpeningHoursDTO(jsonObject));
            }

        } catch (Exception e) {
            Log.e("ERROR", "ServiceDetailDTO", e);
        }
        return serviceDetailDTOBuilder.build();
    }

    /**
     * Parse JSON object to AddressDTO Java object
     * @param jsonObject json object
     * @return AddressDTO Java object
     */
    public static AddressDTO parseJSONToAddressDTO(JSONObject jsonObject) {
        AddressDTO.AddressDTOBuilder addressDTOBuilder = AddressDTO.builder();
        try {
            if (!jsonObject.isNull("itemId")) {
                addressDTOBuilder.itemId(jsonObject.getString("itemId"));
            }
            if (!jsonObject.isNull("placeId")) {
                addressDTOBuilder.placeId(jsonObject.getString("placeId"));
            }
            if (!jsonObject.isNull("formattedAddress")) {
                addressDTOBuilder.formattedAddress(jsonObject.getString("formattedAddress"));
            }
            if (!jsonObject.isNull("addressComponents")) {
                addressDTOBuilder.addressComponents(jsonObject.getString("addressComponents"));
            }
            if (!jsonObject.isNull("types")) {
                addressDTOBuilder.types(jsonObject.getString("types"));
            }
            if (!jsonObject.isNull("latitude")) {
                addressDTOBuilder.latitude(new BigDecimal(jsonObject.getString("latitude")));
            }
            if (!jsonObject.isNull("longitude")) {
                addressDTOBuilder.longitude(new BigDecimal(jsonObject.getString("longitude")));
            }
            if (!jsonObject.isNull("address")) {
                addressDTOBuilder.address(jsonObject.getString("address"));
            }
            if (!jsonObject.isNull("street")) {
                addressDTOBuilder.street(jsonObject.getString("street"));
            }
            if (!jsonObject.isNull("district")) {
                addressDTOBuilder.district(jsonObject.getString("district"));
            }
            if (!jsonObject.isNull("city")) {
                addressDTOBuilder.city(jsonObject.getString("city"));
            }
            if (!jsonObject.isNull("country")) {
                addressDTOBuilder.country(jsonObject.getString("country"));
            }

        } catch (Exception e) {
            Log.e("ERROR", "AddressDTO", e);
        }
        return addressDTOBuilder.build();
    }

    /**
     * Parse JSON object to OpeningHoursDTO Java object
     * @param jsonObject json object
     * @return OpeningHoursDTO Java object
     */
    public static List<OpeningHoursDTO> parseJSONToOpeningHoursDTO(JSONObject jsonObject) {
        List<OpeningHoursDTO> openingHoursDTOList = new ArrayList<OpeningHoursDTO>();
        try {
            if (!jsonObject.isNull("openingHoursList")) {
                JSONArray jsonArray = jsonObject.getJSONArray("openingHoursList");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject openingHoursJSONObject = jsonArray.getJSONObject(i);
                    OpeningHoursDTO.OpeningHoursDTOBuilder openingHoursDTOBuilder = OpeningHoursDTO.builder();
                    if (!openingHoursJSONObject.isNull("itemId")) {
                        openingHoursDTOBuilder.itemId(openingHoursJSONObject.getString("itemId"));
                    }
                    if (!openingHoursJSONObject.isNull("timeZone")) {
                        openingHoursDTOBuilder.timeZone(openingHoursJSONObject.getString("timeZone"));
                    }
                    if (!openingHoursJSONObject.isNull("openDay")) {
                        openingHoursDTOBuilder.openDay(openingHoursJSONObject.getString("openDay"));
                    }
                    if (!openingHoursJSONObject.isNull("openTime")) {
                        openingHoursDTOBuilder.openTime(new Date(openingHoursJSONObject.getLong("openTime")));
                    }
                    if (!openingHoursJSONObject.isNull("closeDay")) {
                        openingHoursDTOBuilder.closeDay(openingHoursJSONObject.getString("closeDay"));
                    }
                    if (!openingHoursJSONObject.isNull("openTime")) {
                        openingHoursDTOBuilder.closeTime(new Date(openingHoursJSONObject.getLong("openTime")));
                    }
                    openingHoursDTOList.add(openingHoursDTOBuilder.build());
                }
            }
        } catch (Exception e) {
            Log.e("ERROR", "OpeningHoursDTO", e);
        }
        return openingHoursDTOList;
    }
}
