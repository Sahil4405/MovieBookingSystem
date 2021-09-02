package com.sahil.movieBookingSystem.services;

import com.sahil.movieBookingSystem.entities.Language;
import com.sahil.movieBookingSystem.exceptions.LanguageDetailsNotFoundException;

import java.util.List;

public interface LanguageService {

    public Language acceptLanguageDetails(Language language);
    public Language getLanguageDetails(int id) throws LanguageDetailsNotFoundException;
    public Language getLanguageDetailsByLanguageName(String languageName) throws LanguageDetailsNotFoundException;
    public boolean deleteLanguage(int id) throws LanguageDetailsNotFoundException;
    public List<Language> getAllLanguageDetails();
}
