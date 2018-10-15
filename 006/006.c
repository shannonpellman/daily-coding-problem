#include <assert.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

struct Node {
    int value;
    struct Node *both;
};

struct Node * xor_addr(struct Node *a, struct Node *b) {
    return (struct Node *)((uintptr_t)a ^ (uintptr_t)b);
}

void add(struct Node **head, int value) {
    struct Node *new_node = (struct Node *)malloc(sizeof(struct Node));

    new_node->value = value;
    new_node->both = NULL;

    if (*head == NULL) {
        *head = new_node;

        return;
    }

    struct Node *curr = *head;
    struct Node *prev = NULL;

    while (curr->both != NULL) {
        struct Node *next = xor_addr(prev, curr->both);

        if (next == NULL) {
            break;
        }

        prev = curr;
        curr = next;
    }

    curr->both = xor_addr(prev, new_node);
    new_node->both = xor_addr(curr, NULL);
}

struct Node * get(struct Node **head, int index) {
    if (*head == NULL) {
        return NULL;
    }

    int i = 0;

    struct Node *curr = *head;
    struct Node *prev = NULL;

    while (i < index && curr != NULL) {
        struct Node *next = xor_addr(prev, curr->both);
        prev = curr;
        curr = next;
        i++;
    }

    return curr;
}

int main() {
    struct Node *head = NULL;

    add(&head, 1);
    add(&head, 2);
    add(&head, 3);
    add(&head, 5);
    add(&head, 8);

    struct Node *node = get(&head, 3);

    assert(node->value == 5);
}