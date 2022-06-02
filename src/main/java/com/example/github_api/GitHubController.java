package com.example.github_api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/github")
@RequiredArgsConstructor
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping("/{name}")
    //Modifier + (static) + void oder Datentyp + Name der Methode + (Parameter) + {}

    //Modifier regelt Zugriff ( Privat, Public )
    //Wenn Static ist es unabhängig von der Klasse muss also kein Objekt der Klasse erzeugt werden
    //Datentyp des Rückgabewerts in diesem Fall : List
    //Wird Kein Rückgabewert erwartet dann : void
    //Name der Methode () Bsp: Currywurst : ()
    //In die Klammern (Parameter) {auszuführende Befehle} Bsp: Name der Methode (String name ) { returnx; }

    public List<String> getRepositoryNames (@PathVariable String name) {
        return gitHubService.getRepositoryNames(name);
    }
}
