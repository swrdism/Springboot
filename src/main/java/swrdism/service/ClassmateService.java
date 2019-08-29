package swrdism.service;

//import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swrdism.Classmate;
import swrdism.exception.NotFoundException;
import swrdism.QueryParameter;
import swrdism.repository.ClassmateRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class ClassmateService {

    @Resource
    private ClassmateRepository repository;

    public Classmate getClassmate(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can't find product."));
        //return null;
    }

    @Transactional
    public Classmate createClassmate(Classmate request) {

        return repository.save(request);
        //return null;
    }

    public Classmate replaceClassmate(int id, Classmate request) {
//        Classmate oldClassmate = getClassmate(id);
//
//        Classmate classmate = new Classmate();
//        classmate.setName(request.getName());
//        classmate.setId(oldClassmate.getId());
//        classmate.setScore(request.getScore());
//
//        return repository.save(classmate);
        return null;
    }

    public void deleteClassmate(int id) {
//        repository.deleteById(id);
    }

    public List<Classmate> getClassmates(QueryParameter param) {
//
        return null;
    }


//    private List<Classmate> classmateDB = new ArrayList<>();
//
//    public Classmate getClassmate(String id){
//        return classmateDB.stream()
//                .filter(p-> p.getId().equals(id))
//                .findFirst()
//                .orElseThrow(()->new NotFoundException("Can't find the classmate."));
//    }
//
//    public Classmate createClassmate(Classmate request){
//
//        boolean isIdDuplicated = classmateDB.stream()
//                .anyMatch(p -> p.getId().equals(request.getId()));
//
//        if(isIdDuplicated){
//            throw new UnprocessableException("Id is duplicated");
//        }
//
//        Classmate classmate = new Classmate();
//        classmate.setName(request.getName());
//        classmate.setId(request.getId());
//        classmate.setScore(request.getScore());
//        classmateDB.add(classmate);
//
//        return  classmate;
//    }
//
//    public Classmate replaceClassmate(String id, Classmate request){
//        Classmate oldClassmate = getClassmate(id);
//        int classmateIndex = classmateDB.indexOf(oldClassmate);
//
//        Classmate classmate = new Classmate();
//        classmate.setName(request.getName());
//        classmate.setId(request.getId());
//        classmate.setScore(request.getScore());
//        classmateDB.set(classmateIndex,classmate);
//
//        return classmate;
//    }
//
//    public void deleteClassmate(String id){
//        Classmate classmate = getClassmate(id);
//        classmateDB.remove(classmate);
//    }
//
//    public List<Classmate> getClassmates(QueryParameter param){
//        Stream<Classmate> stream =classmateDB.stream();
//
//        if (param.getKeyword() != null){
//            stream = stream.filter( p -> p.getName().contains((param.getKeyword())));
//        }
//
//        if ("score".equals(param.getOrderBy()) && param.getSortRule() != null){
//            Comparator<Classmate> comparator = param.getSortRule().equals("asc")?
//                    Comparator.comparing(Classmate::getScore):
//                    Comparator.comparing(Classmate::getScore).reversed();
//            stream = stream.sorted(comparator);
//        }
//        return stream.collect(Collectors.toList());
//    }

}
