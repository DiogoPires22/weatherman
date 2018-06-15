package com.weatherman.diogosilva.weatherman.api.results;

import com.google.gson.annotations.SerializedName;

/**
 * Created by diogosilva on 15/06/18.
 */

@AutoValue
public abstract class WeatherResult{

    @SerializedName("as_of")
    public abstract String asOf();

    @SerializedName("created_at")
    public abstract String createdAt();

    @SerializedName("locations")
    public abstract List<LocationsItem> locations();

    @SerializedName("trends")
    public abstract List<TrendsItem> trends();

    public static TypeAdapter<TrendsResponse> typeAdapter(Gson gson) {
        return new AutoValue_TrendsResponse.GsonTypeAdapter(gson);
    }
}