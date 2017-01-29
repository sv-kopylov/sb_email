package sb_email.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import sb_email.persist.Letter;
import sb_email.persist.PostBox;

import java.util.List;

/**
 * Created by Сергей on 27.01.2017.
 */
@Transactional
public interface LetterDao extends CrudRepository <Letter, Long> {


}
