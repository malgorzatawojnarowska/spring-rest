package vod.repository.mem;

import vod.model.Cinema;
import vod.model.Director;
import vod.model.Movie;
import vod.model.Rating;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SampleData {

    static {

        Director smarzowski = new Director(1, "Wojciech", "Smarzowski");
        Director vega = new Director(2, "Patryk", "Vega");
        Director wajda = new Director(3, "Andrzej", "Wajda");
        Director skolimowski = new Director(4, "Jerzy", "Skolimowski");
        Director holland = new Director(5, "Agnieszka", "Holland");

        Movie wolyn = new Movie(1, "Wolyn", "https://ocdn.eu/pulscms-transforms/1/D0gk9kuTURBXy8zYzFhMDRhZS1jOGRiLTQxN2YtOTcwYy1iNjRjZDBkMjc4MDYuanBlZ5GTBc0DFM0BvIGhMAU", smarzowski);
        Movie wesele = new Movie(2, "Wesele", "https://fwcdn.pl/fpo/40/98/124098/7521214.6.jpg", smarzowski);

        Movie polityka = new Movie(3, "Polityka", "https://i.iplsc.com/-/00094J03E94SMPSS-C122.jpg", vega);
        Movie pitbul = new Movie(4, "Pitbul", "https://bi.im-g.pl/im/5b/9b/12/z19510363V,-Pitbull--Nowe-porzadki---rez--Patryk-Vega--plakat.jpg", vega);

        Movie katyn = new Movie(5, "Katyn", "http://www.gokmichalowo.pl/imprezy2007/katyn/plakat_maly.jpg", wajda);
        Movie tatarak = new Movie(6, "Tatarak", "http://gapla.fn.org.pl/public/cache/P21829-483x700.jpg", wajda);

        Movie essential = new Movie(7, "Essential killing", "https://m.media-amazon.com/images/M/MV5BNTE5NjAxMTEzNl5BMl5BanBnXkFtZTcwMjYzMDQ0Ng@@._V1_UX182_CR0,0,182,268_AL_.jpg", skolimowski);
        Movie ferdydurke = new Movie(8, "Ferdydurke", "http://gapla.fn.org.pl/public/cache/P19423-483x700.jpg", skolimowski);

        Movie europaEuropa = new Movie(9, "Europa, Europa", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5JdpqeTXFvoTfsljYkJpjFscwQn9cXg6m3HyxAdHNBsYeuuhb", holland);
        Movie pokot = new Movie(10, "Pokot", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTG77NN3PQ-wjr29Onws-_lCnYCUxbfpxSPqWWEE7MJS8qTuhmJ", holland);

        bind(wolyn, smarzowski);
        bind(wesele, smarzowski);

        bind(polityka, vega);
        bind(pitbul, vega);

        bind(katyn, wajda);
        bind(tatarak, wajda);

        bind(essential, skolimowski);
        bind(ferdydurke, skolimowski);

        bind(europaEuropa, holland);
        bind(pokot, holland);

        Cinema kinoteka = new Cinema(1, "Kinoteka", "https://www.kinoteka.pl/img/logo.png");
        Cinema podBaranami = new Cinema(2, "Kino pod Baranami", "http://www.festiwalfilmuniemego.pl/wp-content/uploads/2015/11/Kino-pod-Baranami.png");
        Cinema noweHoryzonty = new Cinema(3, "Kino Nowe Horyzonty", "https://i2.wp.com/garretreza.pl/wp-content/uploads/2018/07/nh.jpg");
        Cinema zak = new Cinema(4, "Kino Zak", "https://static2.s-trojmiasto.pl/zdj/c/n/19/2276/250x0/2276445.jpg");

        bind(kinoteka, wesele);
        bind(kinoteka, tatarak);
        bind(europaEuropa, holland);

        bind(noweHoryzonty, wesele);
        bind(noweHoryzonty, wolyn);
        bind(noweHoryzonty, polityka);

        bind(zak, tatarak);
        bind(zak, essential);

        bind(podBaranami, essential);
        bind(podBaranami, polityka);
        bind(podBaranami, pokot);

        addMovie(wolyn);
        addMovie(wesele);
        addMovie(polityka);
        addMovie(pitbul);
        addMovie(katyn);
        addMovie(tatarak);
        addMovie(essential);
        addMovie(ferdydurke);
        addMovie(pokot);
        addMovie(europaEuropa);

        addDirector(smarzowski);
        addDirector(vega);
        addDirector(wajda);
        addDirector(skolimowski);
        addDirector(holland);

        addCinema(kinoteka);
        addCinema(podBaranami);
        addCinema(noweHoryzonty);
        addCinema(zak);

        addRating(Rating.of(pitbul, 1.0F));
        addRating(Rating.of(pitbul, 1.1F));
        addRating(Rating.of(wesele, 4.5F));
        addRating(Rating.of(wesele, 5.0F));
        addRating(Rating.of(polityka, 3.0F));
        addRating(Rating.of(tatarak, 4.9F));
        addRating(Rating.of(tatarak, 5.0F));
        addRating(Rating.of(europaEuropa, 4.1F));
        addRating(Rating.of(europaEuropa, 4.9F));
    }

    private static void addMovie(Movie m){
        MemMovieDao.movies.add(m);
    }

    private static void addDirector(Director d){
        MemDirectorDao.directors.add(d);
    }

    private static void addCinema(Cinema c){
        MemCinemaDao.cinemas.add(c);
    }

    private static void addRating(Rating r){
        new MemRatingDao().save(r);
    }

    private static void bind(Cinema c, Movie m) {
        c.addMovie(m);
        m.addCinema(c);
    }

    private static void bind(Movie m, Director d) {
        d.addMovie(m);
        m.setDirector(d);
    }

}
