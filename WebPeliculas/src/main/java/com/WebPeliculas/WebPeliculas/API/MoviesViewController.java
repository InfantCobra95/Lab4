package com.WebPeliculas.WebPeliculas.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.WebPeliculas.WebPeliculas.Model.Movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoviesViewController {
    @GetMapping("/MovieList")
    public String Test(Locale locale) {
        var message = ResourceBundle.getBundle("i18n\\messages", locale);
        return "index";
    }

    public static ArrayList<Movie> movies = new ArrayList<>();

    public static void addMoviesToArray(){
        Movie Pokemon1 = new Movie(1,"Pokemon The First Movie: Mewtwo Strikes Back", 1998, "PokemonFilm1.jpg", "La aventura empieza de forma explosiva con el debut de Mewtwo, un Pokémon de bioingeniería creado con el ADN de Mew, uno de los Pokémon más especiales que existen. Después de escaparse del laboratorio en el que fue creado, Mewtwo está decidido a probar su superioridad, así que reúne a un selecto número de Entrenadores para que participen en un combate Pokémon como nunca antes se había visto. Y, por supuesto, ¡Ash y sus amigos están encantados de aceptar el reto! El entusiasmo de Ash se convierte en miedo y enfado cuando Mewtwo revela su plan de dominación, creando poderosos clones de todos los Pokémon de nuestros héroes para igualar el “desequilibrio” entre los Pokémon y sus Entrenadores. A pesar de las protestas de Ash, Mewtwo se niega a creer que Pokémon y humanos puedan ser amigos. Teniendo que enfrentarse a la determinación y lealtad de un joven Entrenador, Mewtwo tendrá que reconsiderarlo todo, ¡especialmente cuando se enfrente al poder del misterioso Mew!");
            Movie Pokemon2 = new Movie(2,"Pokemon the Movie 2000: The Power of One", 2000, "PokemonFilm2.jpg", "Ash y sus amigos están ahora viajando por las Islas Naranja ¡pero incluso esta aparentemente tranquila conjunto de islas,desperdigada por las aguas muy al sur de Kanto, tiene sus propios misterios, aventuras y Pokémon Legendarios! Lawrence III seguramente lo sabe, por eso ahora estará viajando a las diferentes islas para capturar a los tres pájaros Legendarios: Moltres, Articuno y Zapdos. Pero incluso con toda su fortaleza, estos tres son solo una piedra en el camino hacia una recompensa mucho más grande: ¡Lugia, el guardián del mar! Por supuesto, Ash no sabe nada de esto cuando llega a su último destino. Los isleños tienen grandes planes para él también, pero nada tan siniestro; quieren que participe en una ceremonia para reunir tres bolas esenciales de diferentes islas. Cuando el clima en todo el mundo se descontrola, esta tarea toma una nueva importancia, ya que la captura de los pájaros Legendarios ha llevado a que el medio ambiente se desequilibre. Con la ayuda de Lugia, ¿puede ser Ash el “elegido” al que todo el mundo recurre?");
            Movie Pokemon3 = new Movie(3,"Pokemon 3: The Unknown Spells Adventure", 2000, "PokemonFilm3.jpg", "La pequeña Molly Hale siempre ha llevado una vida solitaria, pero las cosas se le ponen peor cuando Unown, desaparecido durante mucho tiempo, hace que su padre desaparezca un día misteriosamente.Las cosas parecen mejorar cuando el poderoso Unown comienza a cambiar el mundo a su alrededor en una tierra de fantasía. ¡Pronto vive en un palacio de cristal, y tiene al Entei Legendario como padre! Solo le falta una cosa: una madre, de modo que Molly termina reclamando a la madre de otro para que sea la suya: ¡Delia Ketchum, la mamá de Ash! Ash estaba pensando en pasar un rato divertido en la ciudad de Greenfield, pero ahora debe aventurarse en un gran páramo de cristal para rescatar a la persona más importante para él. Brock, Misty y Pikachu están allí a su lado, pero no será fácil: Molly quiere quedarse en su mundo de fantasía para siempre, ¡y Entei hará todo lo que pueda para que esto suceda!");
            Movie CasoSlevin = new Movie(4,"El Caso Slevin", 2006, "ElCasoSlevin.jpg", "Una situación de identidad equivocada pone a un hombre llamado Slevin (Josh Hartnett) en medio de una guerra entre dos grandes del crimen en Nueva York : El Rabbi (Ben Kingsley) y el Boss (Morgan Freeman). Así, bajo la mirada del detective Brikowski (Stanley Tucci) y el ampliamente reconocido asesino Goodkat (Bruce Willis), Slevin deberá idear un plan para salvar su vida antes de que sea demasiado tarde.");
            Movie Seven = new Movie(5,"Seven", 1995, "Seven.jpg", "Somerset es un solitario y veterano detective a punto de retirarse que se encuentra con Mills, un joven impulsivo. Ambos investigan un particular asesinato. Es este el primero de una serie de crímenes que aluden los siete pecados capitales.");
            Movie Alien1 = new Movie(6,"Alien: el octavo pasajero", 1979, "AlienElOctavoPasajero.jpg", "La tripulación de la nave espacial Nostromo atiende una señal de auxilio y, sin saberlo, sube a bordo una letal forma de vida extraterrestre.");
            Movie Alien2 = new Movie(7,"Alien: el octavo pasajero", 2020, "AlienElOctavoPasajero.jpg", "La tripulación de la nave espacial Nostromo atiende una señal de auxilio y, sin saberlo, sube a bordo una letal forma de vida extraterrestre.");
            movies.add(Pokemon1);
            movies.add(Pokemon2);
            movies.add(Pokemon3);
            movies.add(CasoSlevin);
            movies.add(Seven);
            movies.add(Alien1);
            movies.add(Alien2);
    }

    @GetMapping("/movie/{id}")
    public ModelAndView getMoviesById(@PathVariable(name = "id", required = false) int id) {
        ArrayList<Movie> filtroMovies = new ArrayList<>();

        ModelAndView mv = new ModelAndView("detailMovie");

        if (movies.isEmpty()) {
            addMoviesToArray();
        }

        filtroMovies = getMoviesById(movies, id);

        // model.addAttribute("filtroMovies", filtroMovies);
        mv.addObject("filtroMovies", filtroMovies);
        return mv;
    }

    @GetMapping("")
    public ModelAndView getMovies(@RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "year", required = false, defaultValue = "0") int year/* , Model model */) {
        ArrayList<Movie> filtroMovies = new ArrayList<>();

        ModelAndView mv = new ModelAndView("index");

        if (movies.isEmpty()) {
            addMoviesToArray();
        }

        if (name.equals("") && year == 0) {
            mv.addObject("filtroMovies", movies);
            return mv;
        }
        if (!name.equals("")) {
            filtroMovies = getMoviesByName(movies, name);
            if (year != 0) {
                filtroMovies = getMoviesByYear(filtroMovies, year);
            }

        } else {
            filtroMovies = getMoviesByYear(movies, year);

        }

        // model.addAttribute("filtroMovies", filtroMovies);
        mv.addObject("filtroMovies", filtroMovies);
        return mv;
    }

    public ArrayList<Movie> getMoviesByName(List<Movie> movies, String name) {
        ArrayList<Movie> moviesByName = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (((movies.get(i).getName()).toUpperCase()).contains(name.toUpperCase())) {
                moviesByName.add(movies.get(i));
            }
        }
        return moviesByName;
    }

    public ArrayList<Movie> getMoviesByYear(List<Movie> movies, int year) {
        ArrayList<Movie> moviesByYear = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getYear() == year) {
                moviesByYear.add(movies.get(i));
            }
        }
        return moviesByYear;
    }

    public ArrayList<Movie> getMoviesById(List<Movie> movies, int id) {
        ArrayList<Movie> moviesById = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == id) {
                moviesById.add(movies.get(i));
            }
        }
        return moviesById;
    }

}
