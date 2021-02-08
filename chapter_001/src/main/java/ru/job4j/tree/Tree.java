package ru.job4j.tree;

import java.util.Optional;
import java.util.*;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> rsl = findBy(parent);

        if (rsl.isPresent()) {
            for (Node<E> val
                    :rsl.get().children) {
                if (findBy(child).isPresent()) {
                    return false;
                }
            }
            rsl.get().children.add(new Node<>(child));
            return true;
        }
        return false;
    }

    @Override
    public boolean isBinary() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> rsl = data.poll();
            if (rsl.children.size() > 2) {
                return false;
            } else {
                data.addAll(rsl.children);
            }
        }

        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
