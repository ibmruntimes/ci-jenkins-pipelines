class Config19 {

    final Map<String, Map<String, ?>> buildConfigurations = [
        x64Mac    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels: 'hw.arch.x86 && sw.os.osx.10_15',
                additionalTestLabels: [
                        openj9      : '!sw.os.osx.10_11'
                ],
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                bootJDK             : '18',
                configureArgs       : [
                        temurin     : '--enable-dtrace',
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        x64Linux  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : [
                        openj9      : 'hw.arch.x86 && sw.os.linux'
                ],
                dockerImage: [
                        temurin     : 'adoptopenjdk/centos6_build_image',
                        openj9      : 'adoptopenjdk/centos7_build_image'
                ],
                dockerFile: [
                        openj9      : 'pipelines/build/dockerFiles/cuda.dockerfile'
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
                cleanWorkspaceAfterBuild: true,
                additionalTestLabels: [
                        openj9      : '!(sw.os.cent.6||sw.os.rhel.6)'
                ],
                bootJDK             : '18',
                configureArgs       : [
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"',
                        temurin     : '--enable-dtrace'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-source-archive --create-jre-image --create-sbom'
                ]
        ],

        x64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'x64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        aarch64AlpineLinux  : [
                os                  : 'alpine-linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/alpine3_build_image',
                test                : 'default',
                configureArgs       : '--enable-headless-only=yes',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        x64Windows: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9 : 'hw.arch.x86 && sw.os.windows',
                        temurin : 'win2012&&vs2019'
                ],
                test                : 'default',
                cleanWorkspaceAfterBuild: true,
                bootJDK             : '18',
                configureArgs       : [
                        openj9      :'--with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition" --with-jdk-rc-name="IBM Semeru Runtime"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        aarch64Windows: [
                os                  : 'windows',
                arch                : 'aarch64',
                crossCompile        : 'x64',
                additionalNodeLabels: 'win2016&&vs2019',
                test                : false,
                buildArgs       : [
                        'temurin'   : '--create-jre-image --create-sbom --cross-compile'
                ]
        ],

        x32Windows: [
                os                  : 'windows',
                arch                : 'x86-32',
                additionalNodeLabels: 'win2012&&vs2019',
                test                : 'default',
                buildArgs           : [
                        'temurin'   : '--jvm-variant client,server --create-jre-image --create-sbom'
                ]
        ],

        ppc64Aix    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        temurin     : 'xlc16&&aix720',
                        openj9      : 'hw.arch.ppc64 && sw.os.aix.7_2'
                ],
                test                : 'default',
                bootJDK             : '18',
                configureArgs       : [
                        openj9      : '--disable-ccache --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                additionalTestLabels: [
                        temurin      : 'sw.os.aix.7_2'
                ],
                cleanWorkspaceAfterBuild: true,
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ],
                additionalTestLabels: [
                        temurin      : 'aix720'
                ]
        ],

        s390xLinux    : [
                os                  : 'linux',
                arch                : 's390x',
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
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: 'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)',
                bootJDK             : '18',
                configureArgs       : [
                        temurin     : '--enable-dtrace',
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        ppc64leLinux    : [
                os                  : 'linux',
                arch                : 'ppc64le',
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
                cleanWorkspaceAfterBuild: true,
                additionalNodeLabels: 'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)',
                bootJDK             : '18',
                configureArgs       : [
                        temurin     : '--enable-dtrace',
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        openj9      : 'hw.arch.aarch64 && sw.os.linux'
                ],
                dockerImage         : 'adoptopenjdk/centos7_build_image@sha256:8947557de41e8b5fb0b0e067144b30f7771b182f0f571c12afad846aed6bc6be',
                dockerNode          : 'sw.tool.docker',
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
                                'dev.system',
                                'dev.openjdk'
                        ]
                ],
                bootJDK             : '18',
                configureArgs       : [
                        temurin     : '--enable-dtrace',
                        openj9      : '--enable-dtrace --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        aarch64Mac: [
                os                  : 'mac',
                arch                : 'aarch64',
                additionalNodeLabels: [
                        temurin     : 'macos11',
                        openj9      : 'hw.arch.aarch64 && sw.os.mac'
                ],
                cleanWorkspaceAfterBuild: true,
                bootJDK             : '18',
                configureArgs       : [
                        openj9      : '--enable-dtrace --disable-warnings-as-errors --with-noncompressedrefs --with-product-name="IBM Semeru Runtime" --with-product-suffix="Open Edition"'
                ],
                test                : [
                        temurin : 'default',
                        openj9 : 'default'
                ],
                buildArgs           : [
                        'openj9'    : '--create-jre-image',
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],

        arm32Linux    : [
                os                  : 'linux',
                arch                : 'arm',
                crossCompile        : 'aarch64',
                dockerImage         : 'adoptopenjdk/ubuntu1604_build_image',
                dockerArgs          : '--platform linux/arm/v7',
                test                : 'default',
                configureArgs       : '--enable-dtrace',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ]
        ],
        riscv64Linux      :  [
                os                   : 'linux',
                arch                 : 'riscv64',
                configureArgs        : '--enable-dtrace',
                buildArgs           : [
                        'temurin'   : '--create-jre-image --create-sbom'
                ],
                test                : [
                        nightly: ['sanity.openjdk'],
                        weekly : ['sanity.openjdk', 'sanity.system', 'extended.system', 'sanity.perf']
                ]
        ],

        aarch64Windows: [
                os                  : 'windows',
                arch                : 'aarch64',
                crossCompile        : 'x64',
                additionalNodeLabels: 'win2016&&vs2019',
                test                : false,
                buildArgs       : [
                        'temurin'   : '--create-jre-image --create-sbom --cross-compile'
                ]

        ]
  ]

}

Config19 config = new Config19()
return config.buildConfigurations
