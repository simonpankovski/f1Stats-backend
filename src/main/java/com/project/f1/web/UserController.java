package com.project.f1.web;

import com.project.f1.domain.Constructor;
import com.project.f1.domain.Driver;
import com.project.f1.domain.User;
import com.project.f1.payload.JWTLoginSuccessResponse;
import com.project.f1.payload.LoginRequest;
import com.project.f1.security.JwtTokenProvider;
import com.project.f1.services.ConstructorServiceImpl;
import com.project.f1.services.DriverServiceImpl;
import com.project.f1.services.MapValidationErrorService;
import com.project.f1.services.UserService;
import com.project.f1.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.security.Principal;
import java.util.Set;
import java.io.*;
import java.util.*;
import javax.validation.Valid;

import static com.project.f1.security.SecurityConstants.TOKEN_PREFIX;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private DriverServiceImpl driverService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private ConstructorServiceImpl constructorService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/drivers")
    public List<?> getAllByIdAndDriver(Principal principal) {
        User user = userService.findByName(principal.getName());

        return userService.getAllByIdAndDriver(user.getId());
    }

    @PostMapping("/constructor")
    public ResponseEntity<?> setConstructor(@RequestBody Long constructor, Principal principal){
        User user = userService.findByName(principal.getName());
        user.setConstructor(constructorService.getById(constructor).get());
        User newUser = userService.updateUser(user);
        return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
    }

    @GetMapping("/constructor")
    public Constructor getById(Principal principal){
        User user = userService.findByName(principal.getName());
        return userService.getConstructorById(user.getId());
    }


    @PostMapping("/fantasy")
    public ResponseEntity<?> fantasy(@RequestBody ArrayList<Long> driverList, Principal principal){
        Set<Driver> set = new HashSet<Driver>();
        for (int i=0;i<5;i++){
            Driver d = driverService.findById(driverList.get(i)).get();
            if(d!=null) {
                set.add(d);
            }
        }
        User user = userService.findByName(principal.getName());
        user.setDriverSet(set);
        User newUser = userService.updateUser(user);

        return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX +  tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
        // Validate passwords match
        userValidator.validate(user,result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;
        
        User newUser = userService.saveUser(user);

        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
