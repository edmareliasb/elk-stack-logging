package com.springlogelk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransferService {

    public void execute(Long amount) {

      log.info("Realizando transferencia de {}", amount);

    }

}
