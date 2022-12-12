package com.techelevator.model.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "props",
        "totalResultCount",
        "resultsPerPage",
        "totalPages",
        "currentPage"
})
@Generated("jsonschema2pojo")
public class ZillowRoot {

    @JsonProperty("props")
    private List<Props> props = null;
    @JsonProperty("totalResultCount")
    private Integer totalResultCount;
    @JsonProperty("resultsPerPage")
    private Integer resultsPerPage;
    @JsonProperty("totalPages")
    private Integer totalPages;
    @JsonProperty("currentPage")
    private Integer currentPage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("props")
    public List<Props> getProps() {
        return props;
    }

    @JsonProperty("props")
    public void setProps(List<Props> props) {
        this.props = props;
    }

    @JsonProperty("totalResultCount")
    public Integer getTotalResultCount() {
        return totalResultCount;
    }

    @JsonProperty("totalResultCount")
    public void setTotalResultCount(Integer totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    @JsonProperty("resultsPerPage")
    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    @JsonProperty("resultsPerPage")
    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    @JsonProperty("totalPages")
    public Integer getTotalPages() {
        return totalPages;
    }

    @JsonProperty("totalPages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("currentPage")
    public Integer getCurrentPage() {
        return currentPage;
    }

    @JsonProperty("currentPage")
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
