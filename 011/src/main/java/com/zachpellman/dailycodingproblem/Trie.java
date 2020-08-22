package com.zachpellman.dailycodingproblem;

import com.google.common.collect.ImmutableSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A trie (prefix tree).
 */
public class Trie {

    /**
     * Indicates whether this node in the trie represents the end of a word.
     */
    private boolean isWord;

    /**
     * Children of this node.
     */
    Map<Character, Trie> children;

    /**
     * Constructor.
     *
     * Trie prefix is implied via HashMap key.
     */
    public Trie() {

        this.isWord = false;
        this.children = new HashMap<>();
    }

    /**
     * Static constructor that builds a trie from a dictionary.
     *
     * @param dictionary the dictionary to build the trie from
     *
     * @return A trie containing all words in the dictionary.
     */
    public static Trie of(final Set<String> dictionary) {

        final Trie root = new Trie();
        dictionary.forEach(root::insert);

        return root;
    }

    /**
     * Converts a trie to a dictionary.
     *
     * @param node the starting node in the trie
     * @param prefix the string representing the prefix at the starting node
     *
     * @return A dictionary containing the set of words in the trie.
     */
    public static Set<String> toDictionary(final Trie node, final String prefix) {

        final Set<String> dictionary = new HashSet<>();
        populateDictionary(dictionary, prefix, node);

        return dictionary;
    }

    /**
     * Inserts a word into the trie.
     *
     * @param word the word to insert
     */
    public void insert(final String word) {

        Trie currentNode = this;

        for (final char prefix : word.toCharArray()) {

            if (!currentNode.children.containsKey(prefix)) {
                currentNode.children.put(prefix, new Trie());
            }

            currentNode = currentNode.children.get(prefix);
        }

        currentNode.isWord = true;
    }

    /**
     * Searches for a term in the trie.
     *
     * @param term the term to search for
     *
     * @return A set of words matching the term.
     */
    public Set<String> search(final String term) {

        Trie currentNode = this;

        for (final char prefix : term.toCharArray()) {

            if (!currentNode.children.containsKey(prefix)) {
                return ImmutableSet.of();
            }

            currentNode = currentNode.children.get(prefix);
        }

        return Trie.toDictionary(currentNode, term);
    }

    private static void populateDictionary(Set<String> dictionary, final String word, final Trie node) {

        node.children.forEach((prefix, child) -> {

            if (child.isWord) {
                dictionary.add(word + prefix);
            }

            populateDictionary(dictionary, word + prefix, child);
        });
    }
}
