package com.tjxing.deadlock.analyzer.scanner.maven;

record PomXML(String groupId, String artifactId, String parentId) {

    protected final static class Builder {
        private String groupId;
        private String artifactId;
        private String parentId;

        Builder setGroupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        Builder setArtifactId(String artifactId) {
            this.artifactId = artifactId;
            return this;
        }

        Builder setParentId(String parentId) {
            this.parentId = parentId;
            return this;
        }

        PomXML build() {
            return new PomXML(groupId, artifactId, parentId);
        }
    }

}
