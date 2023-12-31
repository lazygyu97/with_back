package com.sparta.with.dto;

import java.util.List;

import com.sparta.with.entity.Board;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardsResponseDto extends ApiResponseDto {
    private List<BoardResponseDto> boards;

    public static BoardsResponseDto of(List<Board> boards){
        List<BoardResponseDto> boardsResponseDto = boards.stream().map(BoardResponseDto::of).toList();
        return BoardsResponseDto.builder()
                .boards(boardsResponseDto)
                .build();
    }
}
