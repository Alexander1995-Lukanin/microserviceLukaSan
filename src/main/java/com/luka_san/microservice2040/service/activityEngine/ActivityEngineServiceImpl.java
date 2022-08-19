package com.luka_san.microservice2040.service.activityEngine;

import com.luka_san.microservice2040.dto.put.ResolutionEvents;
import com.luka_san.microservice2040.dto.put.ResultResolution;
import com.luka_san.microservice2040.exception.UserIncorrectDataEntryException;
import com.luka_san.microservice2040.webClient.service.EventsServiceIntegrationImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ActivityEngineServiceImpl implements ActivityEngineService {
    private final EventsServiceIntegrationImpl eventsServiceIntegration;




    @Override
    public List<ResultResolution> resultResolution(List<ResolutionEvents> resolutionEvents) throws UserIncorrectDataEntryException, MethodArgumentNotValidException{
        List<ResultResolution> resultResolutions = new ArrayList<>();
        for (ResolutionEvents resolutionEvent : resolutionEvents) {
            resultResolutions.add(eventsServiceIntegration.resolutionEventsIntegration(resolutionEvent));

        }
        return  resultResolutions;
    }


//
//    @Override
//    public void registrationUser(User user) throws UserIncorrectDataEntryException {
//        if (user == null) {
//            throw new UserIncorrectDataEntryException("Введенны некоректные данные");
//        }
//        userRepo.save(user);
//    }
//
//    @Override
//    public User getUserById(Long userId) throws UserNotFoundException {
//        User user;
//        Optional<User> optional = userRepo.findById(userId);
//        if (optional.isPresent()) {
//            user = optional.get();
//        } else {
//            user = serviceIntegration.getUserByIdSync(userId.toString());
//            userRepo.save(user);
//        }
//        return user;
//    }
//
//    @Override
//    public Page<User> getUserAll(Pageable pageable) {
//        return userRepo.findAll(pageable);
//    }
//
//    @Override
//    public Page<User> findAllUsersSortedByFirstName(@SortDefault(sort = "firstName", direction = Sort.Direction.ASC)
//                                                    @PageableDefault(value = 2, page = 0, size = 10) Pageable pageable) {
//        return userRepo.findAll(pageable);
//    }
//
//    @Override
//    public List<User> getUserByLastName(String lastName) {
//        List<User> users = userRepo.findAllByLastName(lastName);
//        return users;
//    }
//
//    @Override
//    public void deleteUser(Long userId) throws UserNotFoundException {
//        if (userRepo.findById(userId).isPresent()) {
//            userRepo.deleteById(userId);
//        } else throw new UserNotFoundException("Такого пользователя не существет");
//    }

    //Вынести в отдельный класс разделить на интрефейс. В пекейдж отдельный. Логика в юзер сервисе. Вызывается.


}
