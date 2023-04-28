package it.gov.pagopa.nodetscollector.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProblemJson {

    @JsonProperty("title")
    @Schema(description = "A short, summary of the problem type. Written in english and readable for engineers (usually not suited for non technical stakeholders and not localized); example: Service Unavailable")
    private String title;

    @JsonProperty("status")
    @Schema(example = "200", description = "The HTTP status code generated by the origin server for this occurrence of the problem.")
    @Min(100)
    @Max(600)
    private Integer status;

    @JsonProperty("details")
    @Schema(example = "There was an error processing the request", description = "A human readable explanation specific to this occurrence of the problem.")
    private String details;

}