package sb_email.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sb_email.persist.Letter;


/**
 * Created by Сергей on 27.01.2017.
 */
@Repository
@Transactional
public interface LetterDao extends CrudRepository <Letter, Long> {


}
