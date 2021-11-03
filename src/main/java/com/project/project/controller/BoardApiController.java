package com.project.project.controller;


import com.project.project.model.Board;
import com.project.project.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;


@RestController
@RequestMapping("/api")
class BoardApiController {

    @Autowired
    private  BoardRepository repository;


    @GetMapping("/boards")
    List<Board> all(@RequestParam(required = false,defaultValue = "")String title,
                    @RequestParam(required = false,defaultValue = "")String content) {
        if(StringUtils.isEmpty(title)&& StringUtils.isEmpty(content)){
            //제목과 타이트링 둘다 빈 값이면 전체 데이터 조회
            return repository.findAll();
        }
        else{
            return repository.findByTitleOrContent(title,content);
        //http://localhost:8080/api/boards?title=글 제목&content=글 내용 으로 api 검색 가능
        }

    }


    @PostMapping("/boards")
    Board newBoard(@RequestBody Board newBoard) {
        return repository.save(newBoard);
        //데이터 추가
    }



    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id) {

        return repository.findById(id).orElse(null);
        //id 값을 비교하여 데이터 조회
    }

    @PutMapping("/boards/{id}")
    Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {

        return repository.findById(id)
                .map(Board -> {
                    Board.setTitle(newBoard.getTitle());
                    Board.setContent(newBoard.getContent());
                    return repository.save(Board);
                })
                .orElseGet(() -> {
                    newBoard.setId(id);
                    return repository.save(newBoard);
                });
        //데이터 수정 update
    }

    @DeleteMapping("/boards/{id}")
    void deleteBoard(@PathVariable Long id) {
        repository.deleteById(id);
        //데이터 삭제
   }
}