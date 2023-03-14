class Config8 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac        : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: [
                        temurin : 'macos10.14',
                        corretto: 'build-macstadium-macos1010-1',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_15'
                ],
                cleanWorkspaceAfterBuild: true,
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test                 : 'default',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        x64Linux      : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile',
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'extended.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'special.system'
                        ],
                        weekly : [
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'sanity.external',
                                'sanity.functional.fips',
                                'extended.functional.fips',
                                'special.functional.fips',
                                'sanity.jck.fips',
                                'extended.jck.fips',
                                'special.jck.fips',
                                'sanity.openjdk.fips',
                                'extended.openjdk.fips',
                                'sanity.system.fips',
                                'extended.system.fips',
                                'special.system.fips',
                                'dev.openjdk'
                        ]
                ],
                configureArgs       : [
                        'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        'dragonwell'  : '--enable-unlimited-crypto --with-jvm-variants=server --with-zlib=system',
                ],
                buildArgs           : [
                        'temurin'   : '--create-source-archive --create-sbom'
                ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--disable-headful',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        aarch64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--disable-headful',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        x64Windows    : [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        temurin : 'win2012&&vs2017',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows',
                        dragonwell: 'win2012'
                ],
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test                 : 'default',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        x32Windows    : [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: [
                        temurin : 'win2012',
                        corretto: 'win2012',
                        openj9  : 'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
                ],
                buildArgs : [
                        temurin : '--jvm-variant client,server --create-sbom'
                ],
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test                 : 'default'
        ],

        ppc64Aix      : [
                os  : 'aix',
                arch: 'ppc64',
                additionalNodeLabels: [
                        temurin: 'xlc13&&aix710',
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_2'
                ],
                test                 : 'default',
                configureArgs: [
                    'openj9'        : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                cleanWorkspaceAfterBuild: true,
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        s390xLinux    : [
                os  : 'linux',
                arch: 's390x',
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                test               : [
                        nightly: [
                                'sanity.functional',
                                'extended.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'special.system'
                        ],
                        weekly : [
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'sanity.external',
                                'dev.openjdk'
                        ]
                ],
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        sparcv9Solaris: [
                os  : 'solaris',
                arch: 'sparcv9',
                test: 'default',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        x64Solaris    : [
                os                  : 'solaris',
                arch                : 'x64',
                test                : 'default',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        ppc64leLinux  : [
                os  : 'linux',
                arch: 'ppc64le',
                test                : [
                        nightly: [
                                'sanity.functional',
                                'extended.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'special.system'
                        ],
                        weekly : [
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'sanity.external',
                                'dev.openjdk'
                        ]
                ],
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        'openj9'      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        arm32Linux    : [
                os: 'linux',
                arch: 'arm',
                crossCompile: 'aarch64',
                dockerImage: 'adoptopenjdk/ubuntu1604_build_image',
                dockerArgs: '--platform linux/arm/v7',
                test: 'default',
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],

        aarch64Linux  : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerFile: [
                        dragonwell: 'pipelines/build/dockerFiles/dragonwell_aarch64.dockerfile'
                ],
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                configureArgs      : '--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                cleanWorkspaceAfterBuild: true,
                test                : [
                        nightly: [
                                'sanity.functional',
                                'extended.functional',
                                'sanity.openjdk',
                                'sanity.perf',
                                'sanity.jck',
                                'sanity.system',
                                'special.system'
                        ],
                        weekly : [
                                'extended.openjdk',
                                'extended.perf',
                                'extended.jck',
                                'extended.system',
                                'special.functional',
                                'special.jck',
                                'dev.system',
                                'dev.openjdk'
                        ]
                ],
                buildArgs           : [
                        'temurin'   : '--create-sbom'
                ]
        ],
  ]

}

Config8 config = new Config8()
return config.buildConfigurations
