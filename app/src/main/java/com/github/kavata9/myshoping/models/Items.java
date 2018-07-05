
package com.github.kavata9.myshoping.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel

public class Items {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("responseGroup")
    @Expose
    private String responseGroup;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("numItems")
    @Expose
    private Integer numItems;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
//    @SerializedName("facets")
//    @Expose
//    private List<Object> facets = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Items() {
    }

    /**
     * 
     * @param sort
     * @param items
     * @param start
     * @param totalResults
     * @param query
     * @param facets
     * @param responseGroup
     * @param numItems
     */
    public Items(String query, String sort, String responseGroup, Integer totalResults, Integer start, Integer numItems, List<Item> items, List<Object> facets) {
        super();
        this.query = query;
        this.sort = sort;
        this.responseGroup = responseGroup;
        this.totalResults = totalResults;
        this.start = start;
        this.numItems = numItems;
        this.items = items;
//        this.facets = facets;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getResponseGroup() {
        return responseGroup;
    }

    public void setResponseGroup(String responseGroup) {
        this.responseGroup = responseGroup;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getNumItems() {
        return numItems;
    }

    public void setNumItems(Integer numItems) {
        this.numItems = numItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

//    public List<Object> getFacets() {
//        return facets;
//    }
//
//    public void setFacets(List<Object> facets) {
//        this.facets = facets;
//    }

}
