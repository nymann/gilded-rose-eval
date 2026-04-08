# Gilded Rose

Java 21+ Maven project. Run tests: `mvn test`

## Test Naming

Name tests after observable behavior, not implementation. Use given/when/then style.

## Architecture

This is a legacy codebase. The `GildedRose.updateQuality()` method is the core logic. `Item` cannot be modified (it belongs to a goblin who will rage-quit).
