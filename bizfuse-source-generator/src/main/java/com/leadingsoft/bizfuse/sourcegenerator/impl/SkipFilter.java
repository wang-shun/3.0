package com.leadingsoft.bizfuse.sourcegenerator.impl;

import java.util.List;
import java.util.regex.Pattern;

import com.leadingsoft.bizfuse.sourcegenerator.ContentsFilter;

public class SkipFilter implements ContentsFilter {

    private final List<String> skipList;

    public SkipFilter(final List<String> skipList) {
        this.skipList = skipList;
    }

    @Override
    public String filter(final String contents) {
        final boolean needSkip = this.skipList.stream().anyMatch(regex -> {
            if (Pattern.matches(regex, contents)) {
                return true;
            } else {
                return false;
            }
        });
        if (needSkip) {
            return null;
        } else {
            return contents;
        }
    }
}
