class Config8 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac        : [
                os                       : 'mac',
                arch                     : 'x64',
                additionalNodeLabels     : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac && sw.tool.xcode.15_2',
                cleanWorkspaceAfterBuild : true,
                test                     : 'default',
                configureArgs            : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                buildArgs                : '--ssh'
        ],

        x64Linux      : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos6',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerFile          : 'pipelines/build/dockerFiles/cuda.dockerfile',
                dockerNode          : 'sw.tool.docker',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.external',
                                'dev.functional',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.external',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2'
                        ]
                ],
                configureArgs       : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                buildArgs           : '--ssh'
        ],

        x64Windows    : [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                test                : 'default',
                configureArgs       : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                buildArgs           : '--ssh'
        ],

        x32Windows    : [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: 'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                buildArgs           : '--ssh',
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test                 : 'default'
        ],

        ppc64Aix      : [
                os                   : 'aix',
                arch                 : 'ppc64',
                additionalNodeLabels : 'hw.arch.ppc64 && sw.os.aix.7_2 && sw.tool.c++runtime.16_1',
                test                 : 'default',
                cleanWorkspaceAfterBuild: true,
                configureArgs        : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                buildArgs            : '--ssh'
        ],

        s390xLinux    : [
                os                   : 'linux',
                arch                 : 's390x',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.s390x',
                dockerImage          : 'sys-rt-docker-local/semeru/s390_rhel7_build_image',
                dockerRegistry       : 'https://docker-na.artifactory.swg-devops.com/',
                dockerCredential     : '7c1c2c28-650f-49e0-afd1-ca6b60479546',
                dockerNode           : 'sw.tool.docker',
                configureArgs        : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test                 : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.external',
                                'dev.functional',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.external',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2'
                        ]
                ],
                buildArgs           : '--ssh'
        ],

        ppc64leLinux  : [
                os               : 'linux',
                arch             : 'ppc64le',
                dockerImage      : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry   : 'https://ghcr.io/',
                dockerFile       : 'pipelines/build/dockerFiles/cuda.dockerfile',
                dockerNode       : 'sw.tool.docker',
                dockerCredential : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                test             : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.external',
                                'dev.functional',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.external',
                                'sanity.jck.fips140_2',
                                'extended.jck.fips140_2',
                                'special.jck.fips140_2',
                                'sanity.openjdk.fips140_2',
                                'extended.openjdk.fips140_2'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux',
                configureArgs        : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                buildArgs            : '--ssh'
        ],

        aarch64Linux  : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerNode          : 'sw.tool.docker',
                additionalNodeLabels: 'hw.arch.aarch64 && sw.os.linux',
                configureArgs       : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                cleanWorkspaceAfterBuild: true,
                test                : [
                        nightly: [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'special.system'
                        ],
                        weekly : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.external',
                                'dev.functional'
                        ],
                        release : [
                                'sanity.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'extended.functional',
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'special.openjdk',
                                'special.system',
                                'sanity.external'
                        ]
                ],
                buildArgs           : '--ssh'
        ]
  ]

}

Config8 config = new Config8()
return config.buildConfigurations
