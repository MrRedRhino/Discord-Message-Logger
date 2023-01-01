package org.pipeman.msg_logger.util;

import de.mkammerer.snowflakeid.SnowflakeIdGenerator;
import de.mkammerer.snowflakeid.options.Options;
import de.mkammerer.snowflakeid.structure.Structure;
import de.mkammerer.snowflakeid.time.MonotonicTimeSource;
import de.mkammerer.snowflakeid.time.TimeSource;

/**
 * Actually 100% unique ID system
 */
public class UID {
    private final SnowflakeIdGenerator generator;

    public UID(int generatorId) {
        generator = SnowflakeIdGenerator.createDefault(generatorId);
    }

    public UID(SnowflakeIdGenerator generator) {
        this.generator = generator;
//        printData();
    }

    public UID(int generatorId, Structure structure) {
        this(SnowflakeIdGenerator.createCustom(generatorId,
                MonotonicTimeSource.createDefault(),
                structure, Options.createDefault()));
    }

    /**
     * @return new unique ID
     */
    public long newUID() {
        return generator.next();
    }

    private void printData() {
        Structure structure = generator.getStructure();
        TimeSource timeSource = generator.getTimeSource();

        System.out.println("Max generators: " + structure.maxGenerators());
        System.out.println("Max sequences per ms per generator: " + structure.maxSequenceIds());
        System.out.println("Max sequences per ms total: " + structure.maxSequenceIds() * structure.maxGenerators());
        System.out.println("Wraparound duration: " + structure.calculateWraparoundDuration(timeSource));
        System.out.println("Wraparound date: " + structure.calculateWraparoundDate(timeSource));
    }
}
