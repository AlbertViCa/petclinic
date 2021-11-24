package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecilatyRepository;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialtyService {

    private final SpecilatyRepository specilatyRepository;

    public SpecialitySDJpaService(SpecilatyRepository specilatyRepository) {
        this.specilatyRepository = specilatyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specilatyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specilatyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specilatyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specilatyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specilatyRepository.deleteById(aLong);
    }
}
