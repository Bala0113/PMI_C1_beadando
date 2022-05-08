# Korház/ügyelet nyilvántartó program
A program célja egy egészségügyi intézmény betegeinek adatainak tárolása.

A betegeknek a következő adatait tárolja el: a beteg tajszámát, nevét, születési dátumát, lakcímét, telefonszámát, hogy az intézmény melyik szobájában van, és a diagnózist.

Az eltárolt adatokat kimenti egy db.xml fájlba, program indulásakor innen beolvassa azokat.

# A program működése
A program indítása után köszönt minket a program és a főmenüben találjuk magunkat ahol, 5 opciónk van,

Új beteg hozzáadása ->  Ezzel új beteget tudunk felvenni az adatbázisba - itt meg kell adnunk a beteg adatait, majd ezekhez az adatokhoz az Xml fájlba tageket rendel.

Szerkesztés         ->  Egy meglévő beteg adatait tudjuk szerkeszteni - egy létező tajszámot kell megadnunk, eztkövetően az Xml fájlba megkeresi a taj tagjei között                             ugyanezt a számot, ha megtalálta akkor az ezzel a taggel rendelkező beteg adatait kiiratja és lehetővé teszi a szerkesztést. 
                        (A beteg tajszámát nem szerkeszthetjük, ez a kulcs a Xml.fájlban való kereséshez.)

Törlés              ->  Egy meglévő beteg adatait tudjuk törölni - egy létező tajszámot kell megadnunk, eztkövetően az Xml fájlba megkeresi a taj tagjei között                                 ugyanezt a számot, és ha szeretnénk akkor az ezzel a tajszámmal rendelkező beteget kitörölhetjük az adatbázisból.

Páciensek listázása -> Kilistázza a betegeket és az adatait - Végig fut az Xml fájlba mentett betegeken és mindegyiket az adataival együtt kimenti egy listába, melyet                        térközökkel kiír a konzolra.

Kilépés             -> Kilép a programból.
