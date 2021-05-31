package com.example.productsservice.Controller;

import com.example.productsservice.Model.*;
import com.example.productsservice.Repository.RolexWatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/admin/")
public class WatchesAdminController {

    public static List<WatchFeatures> watchFeaturesList = new ArrayList<>();
    public static List<WatchFeaturesWithImage> watchFeatureImageSaveListUrl = new ArrayList<>();

    @Autowired
    RolexWatchRepository rolexWatchRepository;

    @RequestMapping(value = "getCurrAdmin", method = RequestMethod.GET)
    public String getCurruser(Principal principal){
        return "Current admin -> " + principal.getName();
    }

    @RequestMapping(value = "deleteWatches", method = RequestMethod.DELETE)
    private String deleteAll() {
        rolexWatchRepository.deleteAll();
        return "watches deleted!";
    }

    @RequestMapping(value = "/deleteWatchByModel", method = RequestMethod.DELETE)
    private String deleteWatch(@RequestParam("watchModel") String watchModel) {
        rolexWatchRepository.deleteWatchByModel(watchModel);
        return "Watch " + watchModel + "has been deleted!";
    }

    @RequestMapping(value = "createWatchAgain", method = RequestMethod.GET)
    private String createWatchesAga() {
        rolexWatchRepository.save(new Watch(23, "Male", "Professional watches", "http://localhost:8082/images/air-king/air-king-card.png", "AIR-KING DESNI", "Oyster, 40 mm, Oystersteel", 6050, "6.050 €", "http://localhost:8082/images/air-king/airkingBackground.jpg", "http://localhost:8082/images/air-king/airking.png", "http://localhost:8082/images/air-king/air-king-night.png", new StaticTextShortAbout("With its 40 mm case in Oystersteel, solid-link Oyster bracelet with Oysterclasp, and distinctive Black dial, the Air-King perpetuates the aeronautical heritage of the original Rolex Oyster.", "The Oyster Perpetual Air-King pays tribute to the pioneers of flight and the Oyster’s roles in the epic story of aviation."), Arrays.asList(new WatchFeaturesWithImage("http://localhost:8082/images/air-king/materials-steel.jpg", "OYSTERSTEEL", "Highly resistant to corrosion"), new WatchFeaturesWithImage("http://localhost:8082/images/air-king/air-king-model-feature-background-steel.jpg", "THE OYSTER BRACELET", "Alchemy of form and function"), new WatchFeaturesWithImage("http://localhost:8082/images/air-king/air-king-movement-calibre.jpg", "3131 MOVEMENT", "Superlative performance")), "http://localhost:8082/images/air-king/air-king-box.jpg", new ModelCase("http://localhost:8082/images/air-king/air-king-model-case.png", "Oyster, 40 mm, Oystersteel", "Monobloc middle case, screw-down case back and winding crown", "40 mm", "Oystersteel", "Smooth", "Screw-down, Twinlock double waterproofness system", "Scratch-resistant sapphire", "Waterproof to 100 metres / 330 feet"), new WatchMovement("http://localhost:8082/images/air-king/air-king-movement.jpg", "Perpetual, mechanical , self-winding , with a magnetic shield to protect the movement", "3131, Manufacture Rolex", "-2/+2 sec/day, after casing", "Centre hour, minute and seconds hands. Stop-seconds for precise time setting", "Paramagnetic blue Parachrom hairspring", "Bidirectional self-winding via Perpetual rotor", "Approximately 48 hours"), new WatchBracelet("http://localhost:8082/images/air-king/air-king-bracelet.png", "Oyster, flat three-piece links", "Oystersteel", "Folding Oysterclasp with Easylink 5 mm comfort extension link"), new WatchDial("http://localhost:8082/images/air-king/air-king-dial.png", "Black", "Highly legible Chromalight display with long-lasting blue luminescence"), new WatchCertification("http://localhost:8082/images/air-king/air-king-certification.jpg", "Superlative Chronometer (COSC + Rolex certification after casing)"), "http://localhost:8082/images/day-date/family-page-push-day-date_96734_flagship_2019_day_date_40_dp_iso_11.jpg"));
        rolexWatchRepository.save(new Watch(54, "Male", "Professional watches", "http://localhost:8082/images/sea-dweller/sea-dweller-card.png", "SEA-DWELLER DESNI", "Oyster, 43 mm, Oystersteel and yellow gold", 15650, "15.650€", "http://localhost:8082/images/sea-dweller/model-cover-background-yellow-gold.jpg", "http://localhost:8082/images/sea-dweller/sea-dweller.png", "http://localhost:8082/images/sea-dweller/sea-dweller-night.png", new StaticTextShortAbout("The Oyster Perpetual Sea-Dweller in Yellow Rolesor with a black ceramic bezel and an Oyster bracelet.", "It features a distinctive black dial and large luminescent hour markers. Waterproof to a depth of 4,000 feet (1,220 metres) with a unidirectional 60-minute rotatable bezel, the Rolex Sea-Dweller is amongst the ultra-resistant divers’ watches engineered by Rolex for deep-sea exploration. "), Arrays.asList(new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/model-feature-background-yellow-gold.jpg", "BLACK DIAL", "Inspired by the original"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/materials-steel-yellow-gold_elmt_1501cw_003.jpg", "YELLOW ROLESOR", "A meeting of two materials"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/model-feature-bracelet-yellow-gold.jpg", "THE OYSTER BRACELET", "Alchemy of from and function"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/helium-valve-sea-dweller-rolesor_elmt_1611jva_001.jpg", "HELIUM ESCAPE VALVE", "Deep-sea equipment"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/cyclop-yellow-gold_elmt_1701rlx_001.jpg", "THE CYCLOPS LENS", "A magnifying lens"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/movement-calibre-3235-y.jpg", "3236 MOVEMENT", "Superlative performance")), "http://localhost:8082/images/sea-dweller/sea-dweller-box.jpg", new ModelCase("http://localhost:8082/images/sea-dweller/sea-dweller-case.png", "Oyster, 43 mm, Oystersteel and yellow gold", "Monobloc middle case, screw-down case back and winding crown", "43 mm", "Yellow Rolesor - combination of Oystersteel and 18 ct yellow gold", "Unidirectional rotatable 60-minute graduated, scratch-resistant Cerachrom insert in ceramic, numerals and graduations coated in gold", "Screw-down, Triplock triple waterproofness system", "Scratch-resistant sapphire, Cyclops lens over the date", "Waterproof to 1,220 metres / 4,000 feet, helium escape valve"), new WatchMovement("http://localhost:8082/images/sea-dweller/movement-calibre-3235.jpg", "Perpetual, mechanical, self-winding", "3235, Manufacture Rolex", "-2/+2 sec/day, after casing", "Centre hour, minute and seconds hands. Instantaneous date with rapid setting. Stop-seconds for precise time setting", "Paramagnetic blue Parachrom hairspring. High-performance Paraflex shock absorbers", "Bidirectional self-winding via Perpetual rotor", "Approximately 70 hours"), new WatchBracelet("http://localhost:8082/images/sea-dweller/sea-dweller-bracelet.png", "Oyster, flat three-piece links", "Yellow Rolesor - combination of Oystersteel and 18 ct yellow gold", "Folding Oysterlock safety clasp with Rolex Glidelock extension system"), new WatchDial("http://localhost:8082/images/sea-dweller/sea-dweller-dial.jpeg", "Black", "Highly legible Chromalight display with long-lasting blue luminescence"), new WatchCertification("http://localhost:8082/images/sea-dweller/sea-dweller-cert.jpg", "Superlative Chronometer (COSC + Rolex certification after casing)"), "http://localhost:8082/images/sea-dweller/sea-dweller-order.jpg"));
        rolexWatchRepository.save(new Watch(65, "Male", "Classic watches", "http://localhost:8082/images/sky-dweller/sky-dweller-card.png", "SKY-DWELLER DESNI", "Oyster, 42 mm, Everose gold", 42000, "42.000 €", "http://localhost:8082/images/sky-dweller/sky-dweller-background.jpg", "http://localhost:8082/images/sky-dweller/shadow_oyster_skydweller_42.png", "http://localhost:8082/images/sky-dweller/sky-dweller-night.png", new StaticTextShortAbout("The Oyster Perpetual Sky-Dweller in 18 ct Everose gold with a dark rhodium dial and an Oyster bracelet.", "This distinctive watch is characterized by its second time zone display on an off-centre disc on the dial. Furthermore, its innovative system for setting the functions, using the rotatable Ring Command bezel, is unique to Rolex. "), Arrays.asList(new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/feature-bezel.jpg", "THE FLUTED BEZEL", "A Rolex signature"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/materials-everose-gold_elmt_1705cw_003.jpg", "18 CT EVEROSE GOLD", "An exclusive patent"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/model-feature-background-everose.jpg", "THE OYSTER BRACELET", "Alchemy of form and function"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/feature-time-zone.jpg", "DUAL TIME ZONE", "Simultaneous display"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/cyclop-everose-gold_elmt_1701rlx_001.jpg", "THE CYCLOPS LENS", "A magnifying lens"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/movement-calibre-9001-p.jpg", "9001 MOVEMENT", "Superlative performance")), "http://localhost:8082/images/sky-dweller/sky-dweller-box.jpg", new ModelCase("http://localhost:8082/images/sky-dweller/sky-dweller-case.png", "Oyster, 42 mm, Everose gold", "Monobloc middle case, screw-down case back and winding crown", "42 mm", "18 ct Everose gold", "Fluted, bidirectional rotatable Rolex Ring Command", "Screw-down, Twinlock double waterproofness system", "Scratch-resistant sapphire, Cyclops lens over the date", "Waterproof to 100 metres / 330 feet"), new WatchMovement("http://localhost:8082/images/sky-dweller/sky-dweller-movement.jpg", "Perpetual, mechanical, self-winding, dual time zones, annual calendar", "9001, Manufacture Rolex", "-2/+2 sec/day, after casing", "Centre hour, minute and seconds hands. 24-hour display on off-centre disc. Second time zone. Instantaneous annual calendar at 3 o'clock and rapid-setting of the date. Month display via 12 apertures around the circumference of the dial. Stop-seconds for precise time setting", "Paramagnetic blue Parachrom hairspring. High-performance Paraflex shock absorbers", "Bidirectional self-winding via Perpetual rotor", "Approximately 72 hours"), new WatchBracelet("http://localhost:8082/images/sky-dweller/sky-dweller-bracelet.png", "Oyster, flat three-piece links", "18 ct Everose gold", "Folding Oysterclasp with Easylink 5 mm comfort extension link"), new WatchDial("http://localhost:8082/images/sky-dweller/sky-dweller-dial.png", "Dark rhodium", "Highly legible Chromalight display with long-lasting blue luminescence"), new WatchCertification("http://localhost:8082/images/sky-dweller/sky-dweller-cert.jpg", "Superlative Chronometer (COSC + Rolex certification after casing)"), "http://localhost:8082/images/sky-dweller/sky-dweller-order-image.jpg"));
        return "Rolex added!";
    }

    @RequestMapping(value = "createWatchHardcode", method = RequestMethod.GET)
    private String createWatches() {
        rolexWatchRepository.save(new Watch(0, "Male", "Professional watches", "http://localhost:8082/images/air-king/air-king-card.png", "AIR-KING", "Oyster, 40 mm, Oystersteel", 6050, "6.050 €", "http://localhost:8082/images/air-king/airkingBackground.jpg", "http://localhost:8082/images/air-king/airking.png", "http://localhost:8082/images/air-king/air-king-night.png", new StaticTextShortAbout("With its 40 mm case in Oystersteel, solid-link Oyster bracelet with Oysterclasp, and distinctive Black dial, the Air-King perpetuates the aeronautical heritage of the original Rolex Oyster.", "The Oyster Perpetual Air-King pays tribute to the pioneers of flight and the Oyster’s roles in the epic story of aviation."), Arrays.asList(new WatchFeaturesWithImage("http://localhost:8082/images/air-king/materials-steel.jpg", "OYSTERSTEEL", "Highly resistant to corrosion"), new WatchFeaturesWithImage("http://localhost:8082/images/air-king/air-king-model-feature-background-steel.jpg", "THE OYSTER BRACELET", "Alchemy of form and function"), new WatchFeaturesWithImage("http://localhost:8082/images/air-king/air-king-movement-calibre.jpg", "3131 MOVEMENT", "Superlative performance")), "http://localhost:8082/images/air-king/air-king-box.jpg", new ModelCase("http://localhost:8082/images/air-king/air-king-model-case.png", "Oyster, 40 mm, Oystersteel", "Monobloc middle case, screw-down case back and winding crown", "40 mm", "Oystersteel", "Smooth", "Screw-down, Twinlock double waterproofness system", "Scratch-resistant sapphire", "Waterproof to 100 metres / 330 feet"), new WatchMovement("http://localhost:8082/images/air-king/air-king-movement.jpg", "Perpetual, mechanical , self-winding , with a magnetic shield to protect the movement", "3131, Manufacture Rolex", "-2/+2 sec/day, after casing", "Centre hour, minute and seconds hands. Stop-seconds for precise time setting", "Paramagnetic blue Parachrom hairspring", "Bidirectional self-winding via Perpetual rotor", "Approximately 48 hours"), new WatchBracelet("http://localhost:8082/images/air-king/air-king-bracelet.png", "Oyster, flat three-piece links", "Oystersteel", "Folding Oysterclasp with Easylink 5 mm comfort extension link"), new WatchDial("http://localhost:8082/images/air-king/air-king-dial.png", "Black", "Highly legible Chromalight display with long-lasting blue luminescence"), new WatchCertification("http://localhost:8082/images/air-king/air-king-certification.jpg", "Superlative Chronometer (COSC + Rolex certification after casing)"), "http://localhost:8082/images/day-date/family-page-push-day-date_96734_flagship_2019_day_date_40_dp_iso_11.jpg"));
        rolexWatchRepository.save(new Watch(1, "Male", "Professional watches", "http://localhost:8082/images/sea-dweller/sea-dweller-card.png", "SEA-DWELLER", "Oyster, 43 mm, Oystersteel and yellow gold", 15650, "15.650€", "http://localhost:8082/images/sea-dweller/model-cover-background-yellow-gold.jpg", "http://localhost:8082/images/sea-dweller/sea-dweller.png", "http://localhost:8082/images/sea-dweller/sea-dweller-night.png", new StaticTextShortAbout("The Oyster Perpetual Sea-Dweller in Yellow Rolesor with a black ceramic bezel and an Oyster bracelet.", "It features a distinctive black dial and large luminescent hour markers. Waterproof to a depth of 4,000 feet (1,220 metres) with a unidirectional 60-minute rotatable bezel, the Rolex Sea-Dweller is amongst the ultra-resistant divers’ watches engineered by Rolex for deep-sea exploration. "), Arrays.asList(new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/model-feature-background-yellow-gold.jpg", "BLACK DIAL", "Inspired by the original"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/materials-steel-yellow-gold_elmt_1501cw_003.jpg", "YELLOW ROLESOR", "A meeting of two materials"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/model-feature-bracelet-yellow-gold.jpg", "THE OYSTER BRACELET", "Alchemy of from and function"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/helium-valve-sea-dweller-rolesor_elmt_1611jva_001.jpg", "HELIUM ESCAPE VALVE", "Deep-sea equipment"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/cyclop-yellow-gold_elmt_1701rlx_001.jpg", "THE CYCLOPS LENS", "A magnifying lens"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/movement-calibre-3235-y.jpg", "3236 MOVEMENT", "Superlative performance")), "http://localhost:8082/images/sea-dweller/sea-dweller-box.jpg", new ModelCase("http://localhost:8082/images/sea-dweller/sea-dweller-case.png", "Oyster, 43 mm, Oystersteel and yellow gold", "Monobloc middle case, screw-down case back and winding crown", "43 mm", "Yellow Rolesor - combination of Oystersteel and 18 ct yellow gold", "Unidirectional rotatable 60-minute graduated, scratch-resistant Cerachrom insert in ceramic, numerals and graduations coated in gold", "Screw-down, Triplock triple waterproofness system", "Scratch-resistant sapphire, Cyclops lens over the date", "Waterproof to 1,220 metres / 4,000 feet, helium escape valve"), new WatchMovement("http://localhost:8082/images/sea-dweller/movement-calibre-3235.jpg", "Perpetual, mechanical, self-winding", "3235, Manufacture Rolex", "-2/+2 sec/day, after casing", "Centre hour, minute and seconds hands. Instantaneous date with rapid setting. Stop-seconds for precise time setting", "Paramagnetic blue Parachrom hairspring. High-performance Paraflex shock absorbers", "Bidirectional self-winding via Perpetual rotor", "Approximately 70 hours"), new WatchBracelet("http://localhost:8082/images/sea-dweller/sea-dweller-bracelet.png", "Oyster, flat three-piece links", "Yellow Rolesor - combination of Oystersteel and 18 ct yellow gold", "Folding Oysterlock safety clasp with Rolex Glidelock extension system"), new WatchDial("http://localhost:8082/images/sea-dweller/sea-dweller-dial.jpeg", "Black", "Highly legible Chromalight display with long-lasting blue luminescence"), new WatchCertification("http://localhost:8082/images/sea-dweller/sea-dweller-cert.jpg", "Superlative Chronometer (COSC + Rolex certification after casing)"), "http://localhost:8082/images/sea-dweller/sea-dweller-order.jpg"));
        rolexWatchRepository.save(new Watch(2, "Male", "Classic watches", "http://localhost:8082/images/sky-dweller/sky-dweller-card.png", "SKY-DWELLER", "Oyster, 42 mm, Everose gold", 42000, "42.000 €", "http://localhost:8082/images/sky-dweller/sky-dweller-background.jpg", "http://localhost:8082/images/sky-dweller/shadow_oyster_skydweller_42.png", "http://localhost:8082/images/sky-dweller/sky-dweller-night.png", new StaticTextShortAbout("The Oyster Perpetual Sky-Dweller in 18 ct Everose gold with a dark rhodium dial and an Oyster bracelet.", "This distinctive watch is characterized by its second time zone display on an off-centre disc on the dial. Furthermore, its innovative system for setting the functions, using the rotatable Ring Command bezel, is unique to Rolex. "), Arrays.asList(new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/feature-bezel.jpg", "THE FLUTED BEZEL", "A Rolex signature"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/materials-everose-gold_elmt_1705cw_003.jpg", "18 CT EVEROSE GOLD", "An exclusive patent"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/model-feature-background-everose.jpg", "THE OYSTER BRACELET", "Alchemy of form and function"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/feature-time-zone.jpg", "DUAL TIME ZONE", "Simultaneous display"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/cyclop-everose-gold_elmt_1701rlx_001.jpg", "THE CYCLOPS LENS", "A magnifying lens"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/movement-calibre-9001-p.jpg", "9001 MOVEMENT", "Superlative performance")), "http://localhost:8082/images/sky-dweller/sky-dweller-box.jpg", new ModelCase("http://localhost:8082/images/sky-dweller/sky-dweller-case.png", "Oyster, 42 mm, Everose gold", "Monobloc middle case, screw-down case back and winding crown", "42 mm", "18 ct Everose gold", "Fluted, bidirectional rotatable Rolex Ring Command", "Screw-down, Twinlock double waterproofness system", "Scratch-resistant sapphire, Cyclops lens over the date", "Waterproof to 100 metres / 330 feet"), new WatchMovement("http://localhost:8082/images/sky-dweller/sky-dweller-movement.jpg", "Perpetual, mechanical, self-winding, dual time zones, annual calendar", "9001, Manufacture Rolex", "-2/+2 sec/day, after casing", "Centre hour, minute and seconds hands. 24-hour display on off-centre disc. Second time zone. Instantaneous annual calendar at 3 o'clock and rapid-setting of the date. Month display via 12 apertures around the circumference of the dial. Stop-seconds for precise time setting", "Paramagnetic blue Parachrom hairspring. High-performance Paraflex shock absorbers", "Bidirectional self-winding via Perpetual rotor", "Approximately 72 hours"), new WatchBracelet("http://localhost:8082/images/sky-dweller/sky-dweller-bracelet.png", "Oyster, flat three-piece links", "18 ct Everose gold", "Folding Oysterclasp with Easylink 5 mm comfort extension link"), new WatchDial("http://localhost:8082/images/sky-dweller/sky-dweller-dial.png", "Dark rhodium", "Highly legible Chromalight display with long-lasting blue luminescence"), new WatchCertification("http://localhost:8082/images/sky-dweller/sky-dweller-cert.jpg", "Superlative Chronometer (COSC + Rolex certification after casing)"), "http://localhost:8082/images/sky-dweller/sky-dweller-order-image.jpg"));
        rolexWatchRepository.save(new Watch(23, "Male", "Professional watches", "http://localhost:8082/images/air-king/air-king-card.png", "AIR-KING DESNI", "Oyster, 40 mm, Oystersteel", 6050, "6.050 €", "http://localhost:8082/images/air-king/airkingBackground.jpg", "http://localhost:8082/images/air-king/airking.png", "http://localhost:8082/images/air-king/air-king-night.png", new StaticTextShortAbout("With its 40 mm case in Oystersteel, solid-link Oyster bracelet with Oysterclasp, and distinctive Black dial, the Air-King perpetuates the aeronautical heritage of the original Rolex Oyster.", "The Oyster Perpetual Air-King pays tribute to the pioneers of flight and the Oyster’s roles in the epic story of aviation."), Arrays.asList(new WatchFeaturesWithImage("http://localhost:8082/images/air-king/materials-steel.jpg", "OYSTERSTEEL", "Highly resistant to corrosion"), new WatchFeaturesWithImage("http://localhost:8082/images/air-king/air-king-model-feature-background-steel.jpg", "THE OYSTER BRACELET", "Alchemy of form and function"), new WatchFeaturesWithImage("http://localhost:8082/images/air-king/air-king-movement-calibre.jpg", "3131 MOVEMENT", "Superlative performance")), "http://localhost:8082/images/air-king/air-king-box.jpg", new ModelCase("http://localhost:8082/images/air-king/air-king-model-case.png", "Oyster, 40 mm, Oystersteel", "Monobloc middle case, screw-down case back and winding crown", "40 mm", "Oystersteel", "Smooth", "Screw-down, Twinlock double waterproofness system", "Scratch-resistant sapphire", "Waterproof to 100 metres / 330 feet"), new WatchMovement("http://localhost:8082/images/air-king/air-king-movement.jpg", "Perpetual, mechanical , self-winding , with a magnetic shield to protect the movement", "3131, Manufacture Rolex", "-2/+2 sec/day, after casing", "Centre hour, minute and seconds hands. Stop-seconds for precise time setting", "Paramagnetic blue Parachrom hairspring", "Bidirectional self-winding via Perpetual rotor", "Approximately 48 hours"), new WatchBracelet("http://localhost:8082/images/air-king/air-king-bracelet.png", "Oyster, flat three-piece links", "Oystersteel", "Folding Oysterclasp with Easylink 5 mm comfort extension link"), new WatchDial("http://localhost:8082/images/air-king/air-king-dial.png", "Black", "Highly legible Chromalight display with long-lasting blue luminescence"), new WatchCertification("http://localhost:8082/images/air-king/air-king-certification.jpg", "Superlative Chronometer (COSC + Rolex certification after casing)"), "http://localhost:8082/images/day-date/family-page-push-day-date_96734_flagship_2019_day_date_40_dp_iso_11.jpg"));
        rolexWatchRepository.save(new Watch(54, "Male", "Professional watches", "http://localhost:8082/images/sea-dweller/sea-dweller-card.png", "SEA-DWELLER DESNI", "Oyster, 43 mm, Oystersteel and yellow gold", 15650, "15.650€", "http://localhost:8082/images/sea-dweller/model-cover-background-yellow-gold.jpg", "http://localhost:8082/images/sea-dweller/sea-dweller.png", "http://localhost:8082/images/sea-dweller/sea-dweller-night.png", new StaticTextShortAbout("The Oyster Perpetual Sea-Dweller in Yellow Rolesor with a black ceramic bezel and an Oyster bracelet.", "It features a distinctive black dial and large luminescent hour markers. Waterproof to a depth of 4,000 feet (1,220 metres) with a unidirectional 60-minute rotatable bezel, the Rolex Sea-Dweller is amongst the ultra-resistant divers’ watches engineered by Rolex for deep-sea exploration. "), Arrays.asList(new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/model-feature-background-yellow-gold.jpg", "BLACK DIAL", "Inspired by the original"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/materials-steel-yellow-gold_elmt_1501cw_003.jpg", "YELLOW ROLESOR", "A meeting of two materials"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/model-feature-bracelet-yellow-gold.jpg", "THE OYSTER BRACELET", "Alchemy of from and function"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/helium-valve-sea-dweller-rolesor_elmt_1611jva_001.jpg", "HELIUM ESCAPE VALVE", "Deep-sea equipment"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/cyclop-yellow-gold_elmt_1701rlx_001.jpg", "THE CYCLOPS LENS", "A magnifying lens"), new WatchFeaturesWithImage("http://localhost:8082/images/sea-dweller/movement-calibre-3235-y.jpg", "3236 MOVEMENT", "Superlative performance")), "http://localhost:8082/images/sea-dweller/sea-dweller-box.jpg", new ModelCase("http://localhost:8082/images/sea-dweller/sea-dweller-case.png", "Oyster, 43 mm, Oystersteel and yellow gold", "Monobloc middle case, screw-down case back and winding crown", "43 mm", "Yellow Rolesor - combination of Oystersteel and 18 ct yellow gold", "Unidirectional rotatable 60-minute graduated, scratch-resistant Cerachrom insert in ceramic, numerals and graduations coated in gold", "Screw-down, Triplock triple waterproofness system", "Scratch-resistant sapphire, Cyclops lens over the date", "Waterproof to 1,220 metres / 4,000 feet, helium escape valve"), new WatchMovement("http://localhost:8082/images/sea-dweller/movement-calibre-3235.jpg", "Perpetual, mechanical, self-winding", "3235, Manufacture Rolex", "-2/+2 sec/day, after casing", "Centre hour, minute and seconds hands. Instantaneous date with rapid setting. Stop-seconds for precise time setting", "Paramagnetic blue Parachrom hairspring. High-performance Paraflex shock absorbers", "Bidirectional self-winding via Perpetual rotor", "Approximately 70 hours"), new WatchBracelet("http://localhost:8082/images/sea-dweller/sea-dweller-bracelet.png", "Oyster, flat three-piece links", "Yellow Rolesor - combination of Oystersteel and 18 ct yellow gold", "Folding Oysterlock safety clasp with Rolex Glidelock extension system"), new WatchDial("http://localhost:8082/images/sea-dweller/sea-dweller-dial.jpeg", "Black", "Highly legible Chromalight display with long-lasting blue luminescence"), new WatchCertification("http://localhost:8082/images/sea-dweller/sea-dweller-cert.jpg", "Superlative Chronometer (COSC + Rolex certification after casing)"), "http://localhost:8082/images/sea-dweller/sea-dweller-order.jpg"));
        rolexWatchRepository.save(new Watch(65, "Male", "Classic watches", "http://localhost:8082/images/sky-dweller/sky-dweller-card.png", "SKY-DWELLER DESNI", "Oyster, 42 mm, Everose gold", 42000, "42.000 €", "http://localhost:8082/images/sky-dweller/sky-dweller-background.jpg", "http://localhost:8082/images/sky-dweller/shadow_oyster_skydweller_42.png", "http://localhost:8082/images/sky-dweller/sky-dweller-night.png", new StaticTextShortAbout("The Oyster Perpetual Sky-Dweller in 18 ct Everose gold with a dark rhodium dial and an Oyster bracelet.", "This distinctive watch is characterized by its second time zone display on an off-centre disc on the dial. Furthermore, its innovative system for setting the functions, using the rotatable Ring Command bezel, is unique to Rolex. "), Arrays.asList(new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/feature-bezel.jpg", "THE FLUTED BEZEL", "A Rolex signature"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/materials-everose-gold_elmt_1705cw_003.jpg", "18 CT EVEROSE GOLD", "An exclusive patent"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/model-feature-background-everose.jpg", "THE OYSTER BRACELET", "Alchemy of form and function"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/feature-time-zone.jpg", "DUAL TIME ZONE", "Simultaneous display"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/cyclop-everose-gold_elmt_1701rlx_001.jpg", "THE CYCLOPS LENS", "A magnifying lens"), new WatchFeaturesWithImage("http://localhost:8082/images/sky-dweller/movement-calibre-9001-p.jpg", "9001 MOVEMENT", "Superlative performance")), "http://localhost:8082/images/sky-dweller/sky-dweller-box.jpg", new ModelCase("http://localhost:8082/images/sky-dweller/sky-dweller-case.png", "Oyster, 42 mm, Everose gold", "Monobloc middle case, screw-down case back and winding crown", "42 mm", "18 ct Everose gold", "Fluted, bidirectional rotatable Rolex Ring Command", "Screw-down, Twinlock double waterproofness system", "Scratch-resistant sapphire, Cyclops lens over the date", "Waterproof to 100 metres / 330 feet"), new WatchMovement("http://localhost:8082/images/sky-dweller/sky-dweller-movement.jpg", "Perpetual, mechanical, self-winding, dual time zones, annual calendar", "9001, Manufacture Rolex", "-2/+2 sec/day, after casing", "Centre hour, minute and seconds hands. 24-hour display on off-centre disc. Second time zone. Instantaneous annual calendar at 3 o'clock and rapid-setting of the date. Month display via 12 apertures around the circumference of the dial. Stop-seconds for precise time setting", "Paramagnetic blue Parachrom hairspring. High-performance Paraflex shock absorbers", "Bidirectional self-winding via Perpetual rotor", "Approximately 72 hours"), new WatchBracelet("http://localhost:8082/images/sky-dweller/sky-dweller-bracelet.png", "Oyster, flat three-piece links", "18 ct Everose gold", "Folding Oysterclasp with Easylink 5 mm comfort extension link"), new WatchDial("http://localhost:8082/images/sky-dweller/sky-dweller-dial.png", "Dark rhodium", "Highly legible Chromalight display with long-lasting blue luminescence"), new WatchCertification("http://localhost:8082/images/sky-dweller/sky-dweller-cert.jpg", "Superlative Chronometer (COSC + Rolex certification after casing)"), "http://localhost:8082/images/sky-dweller/sky-dweller-order-image.jpg"));
        return "Rolex added!";
    }

    @RequestMapping(value = "createFeature", method = RequestMethod.POST, consumes = MULTIPART_FORM_DATA_VALUE)
    public void createFeature(@RequestParam("model") String model, @RequestParam("featureId") String id, @RequestParam("featureImage") MultipartFile featureImage, @RequestParam("featureHead") String featureHead, @RequestParam("featureDesc") String featureDesc) throws IOException {
        System.out.println(id);
        System.out.println(featureImage.getName() + " -> " + featureImage.getSize());
        System.out.println(featureHead);
        System.out.println(featureDesc);
        WatchFeatures watchFeatures = new WatchFeatures(model, id, featureImage, featureHead, featureDesc);
        watchFeaturesList.add(watchFeatures);

        StringBuilder dirName = new StringBuilder("src/main/webapp/images/" + model);

        dirName.replace(23, dirName.length(), model);
        File file = new File(String.valueOf(dirName));
        System.out.println("dirName -> " + dirName);
        System.out.println("ToString -> " + file.toString());
        System.out.println("Name -> " + file.getName());
        Path path = Paths.get(String.valueOf(dirName));

        if (!Files.exists(path)) {
            file.mkdir();
            System.out.printf("File name=%s, size=%s\n", featureImage.getOriginalFilename(), featureImage.getSize());
            String filesave = new File(String.valueOf(dirName)).getAbsolutePath();
            System.out.println(filesave + featureImage.getOriginalFilename());
            File fileToSave = new File((filesave + "/") + featureImage.getOriginalFilename());
            //copy file content from received file to new local file
            watchFeatures.getFeatureImage().transferTo(fileToSave);
        } else {
            System.out.printf("File name=%s, size=%s\n", featureImage.getOriginalFilename(), featureImage.getSize());
            String filesave = new File(String.valueOf(dirName)).getAbsolutePath();
            System.out.println(filesave + featureImage.getOriginalFilename());
            File fileToSave = new File((filesave + "/") + featureImage.getOriginalFilename());
            //copy file content from received file to new local file
            watchFeatures.getFeatureImage().transferTo(fileToSave);
        }
        System.out.println("Before delete");
        for (int i = 0; i < watchFeaturesList.size(); i++) {
            System.out.println(watchFeaturesList.get(i).toString());
            System.out.println(watchFeaturesList.get(i).getFeatureImage().toString());
        }
    }


    @RequestMapping(value = "/deleteFeature/{id}", method = RequestMethod.DELETE)
    public void createFeature(@PathVariable("id") String id) {
        watchFeaturesList.removeIf(e -> e.getId().equals(id));
        System.out.println("After delete");
        watchFeaturesList.forEach(System.out::println);
    }


    @RequestMapping(method = RequestMethod.POST, value = "createWatch", consumes = {"multipart/form-data"})
    public Iterable<Watch> handleFileUpload(@RequestParam("watchCardImage") MultipartFile watchCardImage, @RequestParam("watchBackgroundImage") MultipartFile watchBackgroundImage, @RequestParam("watchImage") MultipartFile watchImage, @RequestParam("watchNightImage") MultipartFile watchNightImage, @RequestParam("watchBoxImage") MultipartFile watchBoxImage, @RequestParam("watchCaseImage") MultipartFile watchCaseImage, @RequestParam("watchMovementImage") MultipartFile watchMovementImage, @RequestParam("watchBraceletImage") MultipartFile watchBraceletImage, @RequestParam("watchDialImage") MultipartFile watchDialImage, @RequestParam("watchCertificationImage") MultipartFile watchCertificationImage, @RequestParam("watchOrderBackgroundImage") MultipartFile watchOrderBackgroundImage, @RequestParam("watchType") String watchType, @RequestParam("model") String model, @RequestParam("description") String description, @RequestParam("price") int price, @RequestParam("priceWord") String priceWord, @RequestParam("firstDesc") String firstDesc, @RequestParam("secondDesc") String secondDesc, @RequestParam("modelCase") String modelCase, @RequestParam("oysterArchitecture") String oysterArchitecture, @RequestParam("diameter") String diameter, @RequestParam("material") String material, @RequestParam("bezel") String bezel, @RequestParam("windingCrown") String windingCrown, @RequestParam("crystal") String crystal, @RequestParam("waterResistance") String waterResistance, @RequestParam("movement") String movement, @RequestParam("calibre") String calibre, @RequestParam("precision") String precision, @RequestParam("functions") String functions, @RequestParam("oscilator") String oscilator, @RequestParam("winding") String winding, @RequestParam("powerReserve") String powerReserve, @RequestParam("bracelet") String bracelet, @RequestParam("braceletMaterial") String braceletMaterial, @RequestParam("clasp") String clasp, @RequestParam("dial") String dial, @RequestParam("dialDetails") String dialDetails, @RequestParam("certification") String certification) throws IOException {
        try {
            System.out.println("MODEL");
            System.out.println(model);
            System.out.println("###############");
            System.out.printf("File name=%s, size=%s\n", watchCardImage.getOriginalFilename(), watchCardImage.getSize());
            System.out.printf("File name=%s, size=%s\n", watchBackgroundImage.getOriginalFilename(), watchBackgroundImage.getSize());
            System.out.printf("File name=%s, size=%s\n", watchImage.getOriginalFilename(), watchImage.getSize());
            System.out.printf("File name=%s, size=%s\n", watchNightImage.getOriginalFilename(), watchNightImage.getSize());
            System.out.println(watchFeaturesList.size());
            ;
            for (int i = 0; i < watchFeaturesList.size(); i++) {
                System.out.println("File name=" + watchFeaturesList.get(i).getFeatureImage().getOriginalFilename() + " size= + " + watchFeaturesList.get(i).getFeatureImage().getSize());
            }
            System.out.printf("File name=%s, size=%s\n", watchBoxImage.getOriginalFilename(), watchBoxImage.getSize());
            System.out.printf("File name=%s, size=%s\n", watchCaseImage.getOriginalFilename(), watchCaseImage.getSize());
            System.out.printf("File name=%s, size=%s\n", watchMovementImage.getOriginalFilename(), watchMovementImage.getSize());
            System.out.printf("File name=%s, size=%s\n", watchBraceletImage.getOriginalFilename(), watchBraceletImage.getSize());
            System.out.printf("File name=%s, size=%s\n", watchDialImage.getOriginalFilename(), watchDialImage.getSize());
            System.out.printf("File name=%s, size=%s\n", watchCertificationImage.getOriginalFilename(), watchCertificationImage.getSize());
            System.out.printf("File name=%s, size=%s\n", watchOrderBackgroundImage.getOriginalFilename(), watchOrderBackgroundImage.getSize());

            String dirName = "src/main/webapp/images/" + model;
            File file = new File(dirName);
            boolean bool = file.mkdirs();
            if (bool) {
                System.out.println("Directory created successfully");
            }
            System.out.println(dirName);

            //filepath on server
            String watchCardImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchBackgroundImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchNightImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchBoxImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchCaseImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchMovementImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchBraceletImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchDialImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchCertificationImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();
            String watchOrderBackgroundImageSave = new File("src/main/webapp/images/" + model + "/").getAbsolutePath();


            //filepath live
            String watchCardImageSaveUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchCardImage.getOriginalFilename();
            String watchBackgroundImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchBackgroundImage.getOriginalFilename();
            String watchImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchImage.getOriginalFilename();
            String watchNightImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchNightImage.getOriginalFilename();
            for (int i = 0; i < watchFeaturesList.size(); i++) {
                watchFeatureImageSaveListUrl.add(new WatchFeaturesWithImage("http://rolexwebsite.com/api/watches/images/" + model + "/" + watchFeaturesList.get(i).getFeatureImage().getOriginalFilename(), watchFeaturesList.get(i).getFeatureHead(), watchFeaturesList.get(i).getFeatureDesc()));
            }
            String watchBoxImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchBoxImage.getOriginalFilename();
            String watchCaseImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchCaseImage.getOriginalFilename();
            String watchMovementImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchMovementImage.getOriginalFilename();
            String watchBraceletImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchBraceletImage.getOriginalFilename();
            String watchDialImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchDialImage.getOriginalFilename();
            String watchCertificationImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchCertificationImage.getOriginalFilename();
            String watchOrderBackgroundImageUrl = "http://rolexwebsite.com/api/watches/images/" + model + "/" + watchOrderBackgroundImage.getOriginalFilename();

            //filepath live
           /* String watchCardImageSaveUrl = "http://localhost:8082/images/" + model + "/" + watchCardImage.getOriginalFilename();
            String watchBackgroundImageUrl = "http://localhost:8082/images/" + model + "/" + watchBackgroundImage.getOriginalFilename();
            String watchImageUrl = "http://localhost:8082/images/" + model + "/" + watchImage.getOriginalFilename();
            String watchNightImageUrl = "http://localhost:8082/images/" + model + "/" + watchNightImage.getOriginalFilename();
            for (int i = 0; i < watchFeaturesList.size(); i++) {
                watchFeatureImageSaveListUrl.add(new WatchFeaturesWithImage("http://localhost:8082/images/" + model + "/" + watchFeaturesList.get(i).getFeatureImage().getOriginalFilename(), watchFeaturesList.get(i).getFeatureHead(), watchFeaturesList.get(i).getFeatureDesc()));
            }
            String watchBoxImageUrl = "http://localhost:8082/images/" + model + "/" + watchBoxImage.getOriginalFilename();
            String watchCaseImageUrl = "http://localhost:8082/images/" + model + "/" + watchCaseImage.getOriginalFilename();
            String watchMovementImageUrl = "http://localhost:8082/images/" + model + "/" + watchMovementImage.getOriginalFilename();
            String watchBraceletImageUrl = "http://localhost:8082/images/" + model + "/" + watchBraceletImage.getOriginalFilename();
            String watchDialImageUrl = "http://localhost:8082/images/" + model + "/" + watchDialImage.getOriginalFilename();
            String watchCertificationImageUrl = "http://localhost:8082/images/" + model + "/" + watchCertificationImage.getOriginalFilename();
            String watchOrderBackgroundImageUrl = "http://localhost:8082/images/" + model + "/" + watchOrderBackgroundImage.getOriginalFilename();
            */



            File watchCardImageToSave = new File((watchCardImageSave + "/") + watchCardImage.getOriginalFilename());
            File watchBackgroundToSave = new File((watchBackgroundImageSave + "/") + watchBackgroundImage.getOriginalFilename());
            File watchImageToSave = new File((watchImageSave + "/") + watchImage.getOriginalFilename());
            File watchNightImageToSave = new File((watchNightImageSave + "/") + watchNightImage.getOriginalFilename());
            File watchBoxImageToSave = new File((watchBoxImageSave + "/") + watchBoxImage.getOriginalFilename());
            File watchCaseImageToSave = new File((watchCaseImageSave + "/") + watchCaseImage.getOriginalFilename());
            File watchMovementImageToSave = new File((watchMovementImageSave + "/") + watchMovementImage.getOriginalFilename());
            File watchBraceletImageToSave = new File((watchBraceletImageSave + "/") + watchBraceletImage.getOriginalFilename());
            File watchDialImageToSave = new File((watchDialImageSave + "/") + watchDialImage.getOriginalFilename());
            File watchCertificationImageToSave = new File((watchCertificationImageSave + "/") + watchCertificationImage.getOriginalFilename());
            File watchOrderBackgroundImageToSave = new File((watchOrderBackgroundImageSave + "/") + watchOrderBackgroundImage.getOriginalFilename());


            //copy file content from received file to new local file
            watchCardImage.transferTo(watchCardImageToSave);
            watchBackgroundImage.transferTo(watchBackgroundToSave);
            watchImage.transferTo(watchImageToSave);
            watchNightImage.transferTo(watchNightImageToSave);


            watchBoxImage.transferTo(watchBoxImageToSave);
            watchCaseImage.transferTo(watchCaseImageToSave);
            watchMovementImage.transferTo(watchMovementImageToSave);
            watchBraceletImage.transferTo(watchBraceletImageToSave);
            watchDialImage.transferTo(watchDialImageToSave);
            watchCertificationImage.transferTo(watchCertificationImageToSave);
            watchOrderBackgroundImage.transferTo(watchOrderBackgroundImageToSave);

            rolexWatchRepository.save(new Watch(10, "Male", watchType, watchCardImageSaveUrl, model, description, price, priceWord, watchBackgroundImageUrl, watchImageUrl, watchNightImageUrl, new StaticTextShortAbout(firstDesc, secondDesc), watchFeatureImageSaveListUrl, watchBoxImageUrl, new ModelCase(watchCaseImageUrl, modelCase, oysterArchitecture, diameter, material, bezel, windingCrown, crystal, waterResistance), new WatchMovement(watchMovementImageUrl, movement, calibre, precision, functions, oscilator, winding, powerReserve), new WatchBracelet(watchBraceletImageUrl, bracelet, braceletMaterial, clasp), new WatchDial(watchDialImageUrl, dial, dialDetails), new WatchCertification(watchCertificationImageUrl, certification), watchOrderBackgroundImageUrl));


            System.out.println();
            System.out.println(watchCardImageSaveUrl);
            System.out.println(watchBackgroundImageUrl);
            System.out.println(watchImageUrl);
            System.out.println(watchNightImageUrl);

            for (int i = 0; i < watchFeatureImageSaveListUrl.size(); i++) {
                System.out.println(watchFeatureImageSaveListUrl.get(i));
            }

            System.out.println(watchBoxImageUrl);
            System.out.println(watchCaseImageUrl);
            System.out.println(watchMovementImageUrl);
            System.out.println(watchBraceletImageUrl);
            System.out.println(watchDialImageUrl);
            System.out.println(watchCertificationImageUrl);
            System.out.println(watchOrderBackgroundImageUrl);
            System.out.println(watchType);
            System.out.println(model);
            System.out.println(description);
            System.out.println(price);
            System.out.println(priceWord);
            System.out.println(firstDesc);
            System.out.println(secondDesc);
            System.out.println(modelCase);
            System.out.println(oysterArchitecture);
            System.out.println(diameter);
            System.out.println(material);
            System.out.println(bezel);
            System.out.println(windingCrown);
            System.out.println(crystal);
            System.out.println(waterResistance);
            System.out.println(movement);
            System.out.println(calibre);
            System.out.println(precision);
            System.out.println(functions);
            System.out.println(oscilator);
            System.out.println(winding);
            System.out.println(powerReserve);
            System.out.println(bracelet);
            System.out.println(braceletMaterial);
            System.out.println(clasp);
            System.out.println(dial);
            System.out.println(dialDetails);
            System.out.println(certification);

            watchFeaturesList.clear();
            System.out.println("WatchFeaturesList cleared");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rolexWatchRepository.findAll();
    }

}
