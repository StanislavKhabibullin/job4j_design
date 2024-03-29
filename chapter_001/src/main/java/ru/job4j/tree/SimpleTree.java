package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SimpleTree<E> {
    boolean add(E parent, E child);

    boolean isBinary();

    Optional<Node<E>> findBy(E value);


    class Node<E> {
        /**
         * final E value;                                     хранимое значение
         * final List<Node<E>> children = new ArrayList<>();  ссылки на дочерние узлы
         */
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
