//package ar.edu.utn.frc.tup.piii.services.impl;
//
//
//import ar.edu.utn.frc.tup.piii.dtos.PlayerDto;
//import ar.edu.utn.frc.tup.piii.dtos.PlayerPostDto;
//import ar.edu.utn.frc.tup.piii.entities.MatchObjectiveEntity;
//import ar.edu.utn.frc.tup.piii.entities.PlayerEntity;
//import ar.edu.utn.frc.tup.piii.repositories.*;
//import ar.edu.utn.frc.tup.piii.services.PlayerService;
//import lombok.Builder;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//@Builder
//public class PlayerServiceImpl implements PlayerService {
//
//    private final PlayerRepository playerRepository;
//    ColorRepository colorRepository;
//    UserRepository userRepository;
//    MatchObjectiveRepository matchObjectiveRepository;
//
//
//
//
//    @Override
//    public PlayerDto savePlayer(PlayerPostDto dto) {
//
//        PlayerEntity playerEntity = new PlayerEntity();
//
//        if(dto.getName() != null){
//            playerEntity.setName(dto.getName());
//
//        }
//        if(dto.getIsCurrentPlayer() != null){
//            playerEntity.setIsCurrentPlayer(dto.getIsCurrentPlayer());
//        }
//
//
//        if(dto.getObjectives() != null){
//            List<MatchObjectiveEntity> objectives = dto.getObjectives().stream()
//                    .map(id -> matchObjectiveRepository.findById(id)
//                            .orElseThrow(() -> new RuntimeException("Objective not found: " + id)))
//                    .collect(Collectors.toList());
//            playerEntity.setObjectives(objectives);
//
//            //Busca en la base de datos el objeto MatchObjective por el id y lo agrega al entity
//        }
//
//        if(dto.getUser() != null){
//            playerEntity.setUser(userRepository.findById(Long.valueOf(dto.getUser()))
//                    .orElseThrow(() -> new RuntimeException("User not found")));
//            //Validacion por si no encuentra
//        }
//        if(dto.getColor() != null){
//            playerEntity.setColor(colorRepository.findById(dto.getColor())
//                    .orElseThrow(() -> new RuntimeException("Colour not found")));
//        }
//        if(dto.getColor() != null){
//            playerEntity.setNumberOfExchanges(dto.getNumberOfExchanges());
//        }
//        if(dto.getTroopsToAdd() != null){
//            playerEntity.setTroopsToAdd(dto.getTroopsToAdd());
//        }
//
//        PlayerEntity saved = playerRepository.save(playerEntity);
//
//        //Se buildea saved a un PlayerResponseDto para devolver como respuesta
//
//        PlayerDto response = new PlayerDto();
//
//        //Se devuelve PlayerDto solo como ejemplo
//        return response ;
//    }
//}
