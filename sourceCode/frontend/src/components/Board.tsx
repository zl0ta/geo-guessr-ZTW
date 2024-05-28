import React from 'react';
import {Cell} from "../api/GameApiClient.ts";


// Type for the props
type BoardProps = {
    board: Cell[][];
    onCellClick?: (x: number, y: number) => void;
    disabled: boolean;
};


const Board: React.FC<BoardProps> = ({ board, onCellClick, disabled}) => {
    const renderCell = (cell: Cell, x: number, y: number) => {
        return (
            <button className="cell" onClick={() => onCellClick!(x, y)} key={x} disabled={disabled || cell !== "EMPTY"}>
                {cell === "EMPTY" ? "" : cell}
            </button>
        );
    };

    const renderRow = (row: Cell[], y: number) => (
        <div className="board-row" key={y}>
            {row.map((cell, x) => renderCell(cell, x, y))}
        </div>
    );

    return (
        <div>
            {board.map((row, y) => renderRow(row, y))}
        </div>
    );
};

export default Board;
