package com.br.artour.Mapper;

import com.br.artour.Entity.Establishment;
import com.br.artour.Model.EstablishmentRequest;

public class EstablishmentRequestToEntity implements InternMapper<Establishment, EstablishmentRequest>{
    @Override
    public Establishment map(EstablishmentRequest request) {
        var record= new Establishment();
        record.setActive(request.isActive());
        record.setHour(request.getHour());
        record.setAttractions(request.getAttractions());
        record.setFees_costs(request.getFees_costs());
        record.setLatitude(request.getLatitude());
        record.setLongitude(request.getLongitude());
        record.setName(request.getName());

        return record;
    }

    @Override
    public Establishment mapUpdate(EstablishmentRequest request, Establishment record) {
        record.setActive(request.isActive());
        record.setHour(request.getHour());
        record.setAttractions(request.getAttractions());
        record.setFees_costs(request.getFees_costs());
        record.setLatitude(request.getLatitude());
        record.setLongitude(request.getLongitude());
        record.setName(request.getName());

        return record;
    }
}
