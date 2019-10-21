package com.direwolf20.buildinggadgets.common.inventory;

import com.direwolf20.buildinggadgets.common.inventory.materials.MaterialList;
import com.direwolf20.buildinggadgets.common.inventory.materials.objects.IUniqueObject;
import com.google.common.collect.ImmutableMultiset;

/**
 * The result of a match by an {@link IItemIndex}. Allows access to the {@link #getMatchedList() matched MaterialList}, the Items which were found, the chosen option and of course
 * whether the match was a success or not.
 */
public final class MatchResult {
    private final MaterialList matchedList;
    private final ImmutableMultiset<IUniqueObject<?>> foundItems;
    private final ImmutableMultiset<IUniqueObject<?>> chosenOption;
    private final boolean isSuccess;

    public static MatchResult success(MaterialList matchedList, ImmutableMultiset<IUniqueObject<?>> foundItems, ImmutableMultiset<IUniqueObject<?>> chosenOption) {
        return new MatchResult(matchedList, foundItems, chosenOption, true);
    }

    public static MatchResult failure() {
        return new MatchResult(MaterialList.empty(), ImmutableMultiset.of(), ImmutableMultiset.of(), false);
    }

    public static MatchResult failure(MaterialList matchedList, ImmutableMultiset<IUniqueObject<?>> foundItems, ImmutableMultiset<IUniqueObject<?>> chosenOption) {
        return new MatchResult(matchedList, foundItems, chosenOption, false);
    }

    MatchResult(MaterialList matchedList, ImmutableMultiset<IUniqueObject<?>> foundItems, ImmutableMultiset<IUniqueObject<?>> chosenOption, boolean isSuccess) {
        this.matchedList = matchedList;
        this.foundItems = foundItems;
        this.chosenOption = chosenOption;
        this.isSuccess = isSuccess;
    }

    public MaterialList getMatchedList() {
        return matchedList;
    }

    public ImmutableMultiset<IUniqueObject<?>> getFoundItems() {
        return foundItems;
    }

    public ImmutableMultiset<IUniqueObject<?>> getChosenOption() {
        return chosenOption;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
