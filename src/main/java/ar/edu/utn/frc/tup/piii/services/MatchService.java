package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.dtos.MatchDto;
import org.springframework.stereotype.Service;

@Service
public interface MatchService {
    MatchDto findMatchById(Integer id);
}
