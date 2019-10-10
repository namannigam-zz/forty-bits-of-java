package edu.forty.bits.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOptimisation {

    public static void main(String[] args) {
        List<Tag> tags = Arrays.asList(new Tag(5),new Tag(6));
        List <Integer> tagIds = Arrays.asList(1,2,3,4);

        // two streams
        List<Integer> ids = tags.stream().map(Tag::getId).collect(Collectors.toList());
        tagIds.stream().filter(tagId -> !ids.contains(tagId)).map(Tag::new).forEach(tags::add);


        // single stream
        tagIds.stream().map(Tag::new).filter(tag -> !tags.contains(tag)).forEach(tags::add);
    }

    private static class Tag {
        Integer id;

        Integer getId() {
            return id;
        }

        Tag(Integer id) {
            this.id = id;
        }
    }
}
