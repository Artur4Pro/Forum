package com.example.forum.service.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

    public String getTokenByUserId(Long id){
        return confirmationTokenRepository.getConfirmationTokenByUserId(id).getToken();
    }
    public ConfirmationToken findConfirmationTokenByToken(String token){
        ConfirmationToken confirmationToken=confirmationTokenRepository.getConfirmationTokenByToken(token);
        return confirmationToken;
    }

}
