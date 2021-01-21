package com.iridium.iridiumskyblock.database.orm;

import com.iridium.iridiumskyblock.schematics.Schematic;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.bukkit.block.Biome;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;

// TODO: Finish this table, persist permissions properly
// also make sure this actually works as intended

/**
 * ORM class representing an island in the database
 *
 * @author BomBardyGamer
 * @since 3.0
 */
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DatabaseTable(tableName = "islands")
public final class Island {

    @DatabaseField(columnName = "id", generatedId = true)
    @Nullable Integer id;

    @DatabaseField(columnName = "name", canBeNull = false)
    @NotNull String name;

    @DatabaseField(columnName = "owner_id", foreign = true, unique = true)
    @NotNull User owner;

    @ForeignCollectionField
    @Setter(AccessLevel.PRIVATE)
    ForeignCollection<User> members;

    @DatabaseField(columnName = "value", canBeNull = false)
    int value;

    @DatabaseField(columnName = "balance", canBeNull = false)
    int balance;

    @DatabaseField(columnName = "experience", canBeNull = false)
    int experience;

    @DatabaseField(columnName = "biome", canBeNull = false)
    @NotNull Biome biome;

    @DatabaseField(columnName = "nether_biome", canBeNull = false)
    @NotNull Biome netherBiome;

    @DatabaseField(columnName = "schematic", canBeNull = false)
    @NotNull String schematic;

    @DatabaseField(columnName = "nether_schematic", canBeNull = false)
    @NotNull String netherSchematic;

    @DatabaseField(columnName = "last_regen")
    @Nullable LocalDateTime lastRegenTime;

    @DatabaseField(columnName = "last_player_caching")
    @Nullable LocalDateTime lastPlayerCaching;
}
