package com.back.p62mission1260730.question;

import com.back.p62mission1260730.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(int id){
        Optional<Question> oq = this.questionRepository.findById(id);

        if(oq.isPresent()){
            return oq.get();
        }else{
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content){
        Question q= new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
}
