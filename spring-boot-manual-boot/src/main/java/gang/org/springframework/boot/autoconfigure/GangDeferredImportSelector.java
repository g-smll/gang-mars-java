package gang.org.springframework.boot.autoconfigure;

import gang.org.springframework.framework.metadata.GangAnnotationMetadata;

public interface GangDeferredImportSelector extends GangImportSelector {

    interface Group
    {
        void process(GangAnnotationMetadata metadata, GangDeferredImportSelector selector);

        class Entry{}
    }
}
