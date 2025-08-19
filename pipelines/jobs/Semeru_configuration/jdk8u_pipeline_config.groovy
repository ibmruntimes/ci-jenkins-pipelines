class Config8 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac        : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        temurin : 'xcode11.7',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.mac && sw.tool.xcode.15_2'
                ],
                cleanWorkspaceAfterBuild: true,
                test                 : 'default',
                configureArgs       : [
                        'openj9'    : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--ssh'
                ]
        ],

        x64Linux      : [
                os                  : 'linux',
                arch                : 'x64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos6',
                dockerRegistry      : 'https://nvcr.io',
                dockerCredential    : '190cfe9d-f1e6-4757-83ea-11ca21498c84',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile',
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
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
                configureArgs       : [
                        'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        'dragonwell'  : '--enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system'
                        ],
                buildArgs           : [
                        'openj9'    : '--ssh'
                ]
        ],

        x64Windows    : [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        temurin : 'win2022&&vs2017',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                        dragonwell: 'win2012'
                ],
                test                 : 'default',
                configureArgs       : [
                        'openj9'    : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--ssh'
                ]
        ],

        x32Windows    : [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: [
                        temurin : 'win2022',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
                ],
                buildArgs : [
                        temurin : '--jvm-variant client,server --create-sbom --use-adoptium-devkit vs2022_redist_14.40.33807_10.0.26100.0',
                        openj9    : '--ssh'
                ],
                configureArgs      : [
                        'openj9'        : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        'temurin'       : '--disable-ccache'
                ],
                test                 : 'default'
        ],

        ppc64Aix      : [
                os  : 'aix',
                arch: 'ppc64',
                additionalNodeLabels: [
                        temurin: 'xlc13&&aix720',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_2 && sw.tool.c++runtime.16_1'
                ],
                test                 : 'default',
                additionalTestLabels : [
                        temurin: 'sw.os.aix.7_2'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs       : [
                        'openj9'    : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--ssh'
                ]
        ],

        s390xLinux    : [
                os  : 'linux',
                arch: 's390x',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'ci.project.openj9 && hw.arch.s390x'
                ],
                dockerImage: 'sys-rt-docker-local/semeru/s390_rhel7_build_image',
                dockerRegistry: 'https://docker-na.artifactory.swg-devops.com/',
                dockerCredential : '7c1c2c28-650f-49e0-afd1-ca6b60479546',
                dockerNode : 'sw.tool.docker',
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test               : [
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
                buildArgs           : [
                        'openj9'    : '--ssh'
                ]
        ],

        ppc64leLinux  : [
                os  : 'linux',
                arch: 'ppc64le',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://nvcr.io',
                dockerFile: [
                    openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                dockerCredential : '190cfe9d-f1e6-4757-83ea-11ca21498c84',
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
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'ci.project.openj9 && hw.arch.ppc64le && sw.os.linux'
                ],
                configureArgs       : [
                        'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                        ],
                buildArgs           : [
                        'openj9'    : '--ssh'

                ]
        ],

        aarch64Linux  : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'ghcr.io/adoptium/adoptium_build_image:centos7',
                dockerRegistry      : 'https://ghcr.io/',
                dockerCredential    : 'f5a0bd2f-093e-41ea-bd6f-875936334a63',
                dockerFile: [
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell_aarch64.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                cleanWorkspaceAfterBuild: true,
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
                buildArgs           : [
                        'openj9'    : '--ssh'
                ]
        ]
  ]

}

Config8 config = new Config8()
return config.buildConfigurations
