# Temat 1 – Gra „Memory” 

Napisz program będący grą w stylu “memory”. Gra polega na odnajdywaniu par takich samych kart. 
Gracz odsłania 2 karty. Jeśli są to takie same karty, zostają one widoczne na planszy, jeśli nie, karty będą zakrywane z powrotem (po 2 sekundach). Celem gracza jest zdjęcie wszystkich kart przy możliwie najszybszym czasie. 

Należy zapewnić w pełni funkcjonalny interfejs graficzny. Konsola poleceń (CLI) może być jedynie pomocą informacyjną, ale nie może zachodzić tam żadna znacząca interakcja użytkownika z programem. 

Program po uruchomieniu powinien wyświetlać menu główne składające się z opcji: 

New Game - nowa gra 

High Scores - tabela wyników 

Exit – wyjście 


Po uruchomieniu nowej gry, gracz zostanie zapytany w osobnym oknie jakiej wielkości pole chce rozwiązać. Należy zauważyć, że sumaryczna ilość kart musi być parzysta, aby każda karta miała swoją parę (na przykład w siatce 3x3 znajduje się 9 kart, więc po odkryciu 4 par jedna zostanie bez). W związku z tym należy zapewnić walidację rozmiarów planszy oraz wyświetlić stosowny błąd użytkownikowi. 
Po uruchomieniu gry w nowym oknie wyświetlane są zakryte karty, a licznik czasu rusza (warto zauważyć, że licznik powinien być realizowany w osobnym wątku, żeby nie blokować interakcji z oknem). Gra toczy się według wyżej wymienionych zasad do momentu odkrycia wszystkich kart. Należy zapewnić możliwość przerwania gry w dowolnym momencie poprzez wybrany przez Państwa złożony skrót klawiszowy (np. Ctrl+Shift+Q), który spowoduje powrót do menu głównego. 

Po zakończeniu gry, w nowym oknie gracz proszony jest o swoją nazwę pod jaką ma być zapisywany w rankingu. 


Dodatkową funkcjonalnością w grze, powinno być pamiętanie sytuacji w której użytkownik poprawnie odgadł parę kart, nie podglądając ich wcześniej. Ilość takich sytuacji powinna być uwzględniona w rankingu. 

Ranking liczony jest na podstawie czasu i wielkości planszy (np. punkty = wielkość planszy/czas w sekundach). W rankingu należy także dodać punkty zależnie od ilości poprawnie odgadniętych pierwszych par. Ranking powinien być posortowany malejąco względem liczby uzyskanych punktów. Należy zapewnić trwałość rankingu po ponownym uruchomieniu aplikacji, czyli należy go przechowywać w pliku na dysku. Postać przechowywanych danych jest sprawą drugorzędną i nie musi być czytelna dla gracza (można wykorzystać np. interfejs Serializable). 
Po wybraniu opcji rankingu z menu głównego, zostaje on wyświetlony użytkownikowi. 
Ponieważ okno rankingu może być relatywnie duże, dlatego należy zadbać o paski przewijania, w razie gdyby nie mieścił się on w oknie racjonalnych rozmiarów. 

Wymagania: 

• Zaimplementowanie głównego mechanizmu gry, opierającego się o wybór i odkrywanie kart oraz zapamiętywanie pierwszych odkrytych par – 5p. 

• Zapewnienie skalowalności głównego okna z grą oraz pasek przewijania okna Highscore w wypadku wyświetlania wielu elementów – 2p. 

• Umożliwienie wyboru wielkości planszy (siatki z kartami do odkrycia) oraz walidacja wyboru użytkownika – 3p. 

• Zaimplementowanie mechanizmu liczącego upływ czasu – 3p. 

• Po rozegranej partii umożliwienie graczowi wpisanie imienia i zapisanie go w Highscore wraz z uzyskanym wynikiem. Wyniki powinny być posortowane malejąco – 3p. 

• Zapewnienie graficznego awersu i rewersu kart, awers powinien mieć przynajmniej klika (5) możliwości, aby skomplikować grę – 3p. 

• Dane dotyczące Highscore powinny być przechowywane w pliku na dysku, zapisywane po skończeniu rozgrywki oraz wczytywane przy uruchomieniu gry. – 3p. 

• Wykorzystanie wzorca MVC (wyjaśnienie jego składowych) oraz zastosowanie/obsługa wyjątków – 3p. 


Projekt opiera się o materiał z zakresu GUI. Aby projekt został poddany ocenie, musi zawierać minimalną funkcjonalność przypominającą grę. 

Należy zastosować w projekcie wzorzec projektowy MVC. Projekt należy wykonać z użyciem technologii JavaFX! 

Uwaga: 

Zabrania się wykorzystywania narzędzi WYSIWYG do generowania okien (tzw. Window Builder`ów, Scene Builder`ów i innych). 

Brak znajomości dowolnej linii kodu lub plagiat skutkować będzie wyzerowaniem punktacji za ten projekt. 

W ocenie projektu poza praktyczną i merytoryczną poprawnością będzie brana również pod uwagę optymalność, jakość i czytelność napisanego przez Państwa kodu. (Rozwiązania nie optymalne, nie czytelne, bądź siłowe skutkują odjęciem punktów) 

Ważną częścią projektu jest wykorzystanie między innymi: dziedziczenia, kolekcji, interfejsów lub klas abstrakcyjnych, lambda-wyrażeń, typów generycznych, dodatkowych funkcjonalności lub struktur oraz innych elementów charakterystycznych (ale tylko w naturalny sposób, nic na siłę) 



