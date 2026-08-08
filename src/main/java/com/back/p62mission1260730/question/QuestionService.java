package com.back.p62mission1260730.question;

import com.back.p62mission1260730.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
