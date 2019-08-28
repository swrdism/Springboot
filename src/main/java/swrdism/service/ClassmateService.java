package swrdism.service;

//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import swrdism.Classmate;
import swrdism.exception.NotFoundException;
import swrdism.exception.UnprocessableException;
import swrdism.QueryParameter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ClassmateService {

//    //@Autowired
//    //private ClassmateRepository repository;
//
//    public Classmate getClassmate(String id) {
////        return repository.findById(id)
////                .orElseThrow(() -> new NotFoundException("Can't find product."));
//        return null;
//    }
//
//    public Classmate createClassmate(Classmate request) {
//
////        Classmate classmate = new Classmate();
////        classmate.setName(request.getName());
////        classmate.setScore(request.getScore());
////        classmate.setId(request.getId());
////
////        return repository.save(classmate);
//        return null;
//    }
//
//    public Classmate replaceClassmate(String id, Classmate request) {
////        Classmate oldClassmate = getClassmate(id);
////
////        Classmate classmate = new Classmate();
////        classmate.setName(request.getName());
////        classmate.setId(oldClassmate.getId());
////        classmate.setScore(request.getScore());
////
////        return repository.save(classmate);
//        return null;
//    }
//
//    public void deleteClassmate(String id) {
////        repository.deleteById(id);
//    }
//
//    public List<Classmate> getClassmates(QueryParameter param) {
////
//        return null;
//    }


    private List<Classmate> classmateDB = new ArrayList<>();

    public Classmate getClassmate(String id){
        return classmateDB.stream()
                .filter(p-> p.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new NotFoundException("Can't find the classmate."));
    }

    public Classmate createClassmate(Classmate request){

        boolean isIdDuplicated = classmateDB.stream()
                .anyMatch(p -> p.getId().equals(request.getId()));

        if(isIdDuplicated){
            throw new UnprocessableException("Id is duplicated");
        }

        Classmate classmate = new Classmate();
        classmate.setName(request.getName());
        classmate.setId(request.getId());
        classmate.setScore(request.getScore());
        classmateDB.add(classmate);

        return  classmate;
    }

    public Classmate replaceClassmate(String id, Classmate request){
        Classmate oldClassmate = getClassmate(id);
        int classmateIndex = classmateDB.indexOf(oldClassmate);

        Classmate classmate = new Classmate();
        classmate.setName(request.getName());
        classmate.setId(request.getId());
        classmate.setScore(request.getScore());
        classmateDB.set(classmateIndex,classmate);

        return classmate;
    }

    public void deleteClassmate(String id){
        Classmate classmate = getClassmate(id);
        classmateDB.remove(classmate);
    }

    public List<Classmate> getClassmates(QueryParameter param){
        Stream<Classmate> stream =classmateDB.stream();

        if (param.getKeyword() != null){
            stream = stream.filter( p -> p.getName().contains((param.getKeyword())));
        }

        if ("score".equals(param.getOrderBy()) && param.getSortRule() != null){
            Comparator<Classmate> comparator = param.getSortRule().equals("asc")?
                    Comparator.comparing(Classmate::getScore):
                    Comparator.comparing(Classmate::getScore).reversed();
            stream = stream.sorted(comparator);
        }
        return stream.collect(Collectors.toList());
    }

}
