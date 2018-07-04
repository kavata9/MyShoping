
package com.github.kavata9.myshoping.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("parentItemId")
    @Expose
    private Integer parentItemId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("msrp")
    @Expose
    private Double msrp;
    @SerializedName("salePrice")
    @Expose
    private Double salePrice;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("categoryPath")
    @Expose
    private String categoryPath;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("longDescription")
    @Expose
    private String longDescription;
    @SerializedName("thumbnailImage")
    @Expose
    private String thumbnailImage;
    @SerializedName("mediumImage")
    @Expose
    private String mediumImage;
    @SerializedName("largeImage")
    @Expose
    private String largeImage;
    @SerializedName("productTrackingUrl")
    @Expose
    private String productTrackingUrl;
    @SerializedName("standardShipRate")
    @Expose
    private Double standardShipRate;
    @SerializedName("modelNumber")
    @Expose
    private String modelNumber;
    @SerializedName("productUrl")
    @Expose
    private String productUrl;
    @SerializedName("customerRating")
    @Expose
    private String customerRating;
    @SerializedName("numReviews")
    @Expose
    private Integer numReviews;
    @SerializedName("customerRatingImage")
    @Expose
    private String customerRatingImage;
    @SerializedName("categoryNode")
    @Expose
    private String categoryNode;
    @SerializedName("rhid")
    @Expose
    private String rhid;
    @SerializedName("bundle")
    @Expose
    private Boolean bundle;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("addToCartUrl")
    @Expose
    private String addToCartUrl;
    @SerializedName("affiliateAddToCartUrl")
    @Expose
    private String affiliateAddToCartUrl;
    @SerializedName("giftOptions")
    @Expose
    private GiftOptions giftOptions;
    @SerializedName("imageEntities")
    @Expose
    private List<ImageEntity> imageEntities = null;
    @SerializedName("offerType")
    @Expose
    private String offerType;
    @SerializedName("isTwoDayShippingEligible")
    @Expose
    private Boolean isTwoDayShippingEligible;
    @SerializedName("availableOnline")
    @Expose
    private Boolean availableOnline;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param affiliateAddToCartUrl
     * @param standardShipRate
     * @param customerRatingImage
     * @param thumbnailImage
     * @param giftOptions
     * @param productTrackingUrl
     * @param stock
     * @param msrp
     * @param categoryNode
     * @param numReviews
     * @param mediumImage
     * @param name
     * @param longDescription
     * @param bundle
     * @param addToCartUrl
     * @param imageEntities
     * @param customerRating
     * @param rhid
     * @param largeImage
     * @param parentItemId
     * @param itemId
     * @param upc
     * @param categoryPath
     * @param offerType
     * @param availableOnline
     * @param shortDescription
     * @param productUrl
     * @param salePrice
     * @param isTwoDayShippingEligible
     * @param modelNumber
     */
    public Item(Integer itemId, Integer parentItemId, String name, Double msrp, Double salePrice, String upc, String categoryPath, String shortDescription, String longDescription, String thumbnailImage, String mediumImage, String largeImage, String productTrackingUrl, Double standardShipRate, String modelNumber, String productUrl, String customerRating, Integer numReviews, String customerRatingImage, String categoryNode, String rhid, Boolean bundle, String stock, String addToCartUrl, String affiliateAddToCartUrl, GiftOptions giftOptions, List<ImageEntity> imageEntities, String offerType, Boolean isTwoDayShippingEligible, Boolean availableOnline) {
        super();
        this.itemId = itemId;
        this.parentItemId = parentItemId;
        this.name = name;
        this.msrp = msrp;
        this.salePrice = salePrice;
        this.upc = upc;
        this.categoryPath = categoryPath;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.thumbnailImage = thumbnailImage;
        this.mediumImage = mediumImage;
        this.largeImage = largeImage;
        this.productTrackingUrl = productTrackingUrl;
        this.standardShipRate = standardShipRate;
        this.modelNumber = modelNumber;
        this.productUrl = productUrl;
        this.customerRating = customerRating;
        this.numReviews = numReviews;
        this.customerRatingImage = customerRatingImage;
        this.categoryNode = categoryNode;
        this.rhid = rhid;
        this.bundle = bundle;
        this.stock = stock;
        this.addToCartUrl = addToCartUrl;
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
        this.giftOptions = giftOptions;
        this.imageEntities = imageEntities;
        this.offerType = offerType;
        this.isTwoDayShippingEligible = isTwoDayShippingEligible;
        this.availableOnline = availableOnline;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(Integer parentItemId) {
        this.parentItemId = parentItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMsrp() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getProductTrackingUrl() {
        return productTrackingUrl;
    }

    public void setProductTrackingUrl(String productTrackingUrl) {
        this.productTrackingUrl = productTrackingUrl;
    }

    public Double getStandardShipRate() {
        return standardShipRate;
    }

    public void setStandardShipRate(Double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    public Integer getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    public String getCustomerRatingImage() {
        return customerRatingImage;
    }

    public void setCustomerRatingImage(String customerRatingImage) {
        this.customerRatingImage = customerRatingImage;
    }

    public String getCategoryNode() {
        return categoryNode;
    }

    public void setCategoryNode(String categoryNode) {
        this.categoryNode = categoryNode;
    }

    public String getRhid() {
        return rhid;
    }

    public void setRhid(String rhid) {
        this.rhid = rhid;
    }

    public Boolean getBundle() {
        return bundle;
    }

    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    public String getAffiliateAddToCartUrl() {
        return affiliateAddToCartUrl;
    }

    public void setAffiliateAddToCartUrl(String affiliateAddToCartUrl) {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    public GiftOptions getGiftOptions() {
        return giftOptions;
    }

    public void setGiftOptions(GiftOptions giftOptions) {
        this.giftOptions = giftOptions;
    }

    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public Boolean getIsTwoDayShippingEligible() {
        return isTwoDayShippingEligible;
    }

    public void setIsTwoDayShippingEligible(Boolean isTwoDayShippingEligible) {
        this.isTwoDayShippingEligible = isTwoDayShippingEligible;
    }

    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

}
