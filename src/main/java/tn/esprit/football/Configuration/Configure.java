package tn.esprit.football.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@Slf4j
@Aspect
public class Configure {
    //after apres execution de la methode
    //apres le bon deroulement
    @AfterReturning("execution(* tn.esprit.football.Service.*.ajouter*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        //Pour nom de la méthode
        String name = joinPoint.getSignature().getName();
        log.info( " Gestion Match :Ajout réalisé avec succès"  );
    }
}
