package com.laioffer.jupiter.entity;


//Builder builder = new Builder();
//builder.setName("vincent").setDeveloper("me");

//Game game = builder.build();
// private constructor
// Game game = new Game(builder);

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// private constructor
// Game game = builder.build();
// public constructor
// Game game = new Game(builder);

//indicates that other fields in the response can be safely ignored. Without this, you’ll get an exception at runtime.
@JsonIgnoreProperties(ignoreUnknown = true)
//indicates that null fields can be skipped and not included.
@JsonInclude(JsonInclude.Include.NON_NULL)
// indicates that Jackson needs to use Game.Builder when constructing a Game object from JSON strings.
@JsonDeserialize(builder = Game.Builder.class)
public class Game {
    @JsonProperty("id")
    private final String id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("box_art_url")
    private final String boxArtUrl;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBoxArtUrl() {
        return boxArtUrl;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Builder {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("box_art_url")
        private String boxArtUrl;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder boxArtUrl(String boxArtUrl) {
            this.boxArtUrl = boxArtUrl;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }

    private Game(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.boxArtUrl = builder.boxArtUrl;
    }


    }
