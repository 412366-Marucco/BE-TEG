package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.dtos.MatchDto;
import ar.edu.utn.frc.tup.piii.entities.MatchEntity;
import ar.edu.utn.frc.tup.piii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.piii.services.MatchService;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Builder
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;


    @Override
    public MatchDto findMatchById(Integer id) {

        MatchEntity matchEntity = matchRepository.getReferenceById(id);

        if(Objects.isNull(matchEntity.getPlayers())){
            throw new EntityNotFoundException();
        }

        //Buscar currentPlayer, objectives, countryGraph, logger, votes
        /*
        MatchDto matchDto = MatchDto.builder()
                .id(matchEntity.getId())
                .players(matchEntity.getPlayers())
                .turnTimer(matchEntity.getTurnTimer())
                .turnPhase(matchEntity.getTurnPhase())
                .countries(matchEntity.getCountries())
                .cards(matchEntity.getCards())
                .winner(matchEntity.getWinner())
                .isFirstRound(matchEntity.isFirstRound())
                .state(matchEntity.getState())
                .build();

        return matchDto;

         */
        return null;

    }
}
