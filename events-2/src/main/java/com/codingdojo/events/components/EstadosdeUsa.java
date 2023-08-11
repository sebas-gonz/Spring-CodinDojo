package com.codingdojo.events.components;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class EstadosdeUsa {
	public List<String> estados = Arrays.asList(
            "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI",
            "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI",
            "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC",
            "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT",
            "VT", "VA", "WA", "WV", "WI", "WY"
    );

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
}
